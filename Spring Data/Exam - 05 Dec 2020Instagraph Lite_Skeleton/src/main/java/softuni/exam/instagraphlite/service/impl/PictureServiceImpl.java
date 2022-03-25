package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURE_PATH = "src/main/resources/files/pictures.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, PictureRepository pictureRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.pictureRepository = pictureRepository;
    }


    @Override
    public boolean areImported() {
        return this.pictureRepository.count()> 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        PictureSeedDto[] pictureSeedDtos = gson.fromJson(readFromFileContent(), PictureSeedDto[].class);
        List<String> paths = new ArrayList<>();

        Arrays.stream(pictureSeedDtos)
                .filter(pictureSeedDto -> {
                    String path = pictureSeedDto.getPath();
                    boolean isValid = validationUtil.isValid(pictureSeedDto);
                    if(paths.contains(path)){
                        isValid = false;
                    } else if (!paths.contains(path) && isValid){
                        paths.add(path);
                    }
                    sb.append(isValid ? String.format("Successfully imported Picture, with size %.2f",
                           pictureSeedDto.getSize())
                            : "Invalid Picture").append(System.lineSeparator());
                    return isValid;
                })
                .map(pictureSeedDto -> modelMapper.map(pictureSeedDto,Picture.class))
                .forEach(pictureRepository::save);

        return sb.toString();
    }

    @Override
    public String exportPictures() {
        StringBuilder build = new StringBuilder();

        List<Picture> pictures = this.pictureRepository.findAllBySizeGreaterThanOrderBySize(30000.0);
        for (Picture picture : pictures) {
            build.append(String.format("%.2f - %s%n",picture.getSize(),picture.getPath()));
        }

        return build.toString();
    }

    @Override
    public Optional<Picture> findPictureByPath(String path) {
        return this.pictureRepository.findByPath(path);
    }


}
