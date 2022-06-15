package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findAllByUsernameAndPassword(String username, String password);

    Optional<User> findAllByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
