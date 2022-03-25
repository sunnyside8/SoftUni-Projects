package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserExportDto;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final String USER_FILE = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;


    public UserServiceImpl(UserRepository userRepository, PictureService pictureService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        UserSeedDto[] userSeedDtos = gson.fromJson(readFromFileContent(), UserSeedDto[].class);

        for (UserSeedDto userSeedDto : userSeedDtos) {
            boolean isValid = validationUtil.isValid(userSeedDto);
            String username = userSeedDto.getUsername();
            Optional<Picture> picture = pictureService.findPictureByPath(userSeedDto.getProfilePicture());
            if(picture.isPresent() && userRepository.getUserByUsername(username).isEmpty() && isValid){
                sb.append(String.format("Successfully imported User: %s",
                        username)).append(System.lineSeparator());
                User user = modelMapper.map(userSeedDto,User.class);
                user.setProfilePicture(picture.get());
                this.userRepository.save(user);
            } else{
                sb.append("Invalid User").append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
       StringBuilder build = new StringBuilder();
        List<User> users = this.userRepository.usersOrderedByCountPosts();

        for (User user : users) {
            build.append(String.format("""
                            User: %s
                            Post count: %d
                            ==Post Details:
                            """
                    ,user.getUsername(),user.getPosts().size()
            ));
            List<Post> postsOrdered = this.userRepository.getAllPostsByUser(user);
            for (Post post : postsOrdered) {
                build.append(String.format("----Caption: %s\n" +
                                "----Picture Size: %.2f\n"
                        ,post.getCaption(),post.getPicture().getSize()));
            }
        }
       return build.toString();
    }

    @Override
    public Optional<User> getUserByUsername(String name) {
        return this.userRepository.getUserByUsername(name);
    }
}
