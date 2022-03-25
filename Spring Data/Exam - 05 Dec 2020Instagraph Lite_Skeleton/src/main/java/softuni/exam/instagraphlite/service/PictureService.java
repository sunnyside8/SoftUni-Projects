package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PictureService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

    Optional<Picture> findPictureByPath(String path);

}
