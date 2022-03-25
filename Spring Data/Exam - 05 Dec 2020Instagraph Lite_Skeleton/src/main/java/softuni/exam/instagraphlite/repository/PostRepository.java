package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;

import java.util.List;


public interface PostRepository extends JpaRepository<Post,Long> {

//    @Query("SELECT p FROM Post p WHERE p.user = :user ORDER BY p.picture.size")
//    List<Post> getAllPostsByUser(User user);
}
