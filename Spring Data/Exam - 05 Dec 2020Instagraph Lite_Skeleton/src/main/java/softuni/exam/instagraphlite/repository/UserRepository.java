package softuni.exam.instagraphlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getUserByUsername(String username);

    @Query("select u FROM User u ORDER BY u.posts.size DESC ")
    List<User> usersOrderedByCountPosts();

    @Query("SELECT p FROM Post p WHERE p.user = :user ORDER BY p.picture.size")
    List<Post> getAllPostsByUser(User user);
}
