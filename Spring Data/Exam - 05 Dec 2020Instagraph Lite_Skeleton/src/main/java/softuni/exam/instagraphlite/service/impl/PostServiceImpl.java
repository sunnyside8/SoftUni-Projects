package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.XmlDto.PostSeedDto;
import softuni.exam.instagraphlite.models.dto.XmlDto.PostsSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private static final String POSTS_DATA = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final UserService userService;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public PostServiceImpl(PostRepository postRepository, UserService userService, PictureService pictureService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return postRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_DATA));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PostsSeedRootDto playerSeedRootDto = xmlParser.fromFile(POSTS_DATA,
                PostsSeedRootDto.class);

        for (PostSeedDto postSeedDto : playerSeedRootDto.getPosts()) {
            boolean isValid = validationUtil.isValid(postSeedDto);

            Optional<Picture> picture = this.pictureService.findPictureByPath(postSeedDto.getPicture().getPath());
            Optional<User> user = this.userService.getUserByUsername(postSeedDto.getUser().getUsername());

            if(isValid && picture.isPresent() && user.isPresent()){
                sb.append(String.format("Successfully imported Post, made by %s",
                        user.get().getUsername()));
                Post post = modelMapper.map(postSeedDto,Post.class);
                post.setUser(user.get());
                post.setPicture(picture.get());
                postRepository.save(post);
            } else{
                sb.append("Invalid Post");
            }
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }
}
