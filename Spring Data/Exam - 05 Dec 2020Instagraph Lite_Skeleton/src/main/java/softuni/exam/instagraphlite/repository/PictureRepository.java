package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.instagraphlite.models.entity.Picture;

import java.util.List;
import java.util.Optional;


public interface PictureRepository extends JpaRepository<Picture,Long> {

    Optional<Picture> findByPath(String path);

    List<Picture> findAllBySizeGreaterThanOrderBySize(Double size);
}
