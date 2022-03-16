package com.example.springmappingobjectsex.repositories;

import com.example.springmappingobjectsex.models.entities.Game;
import com.example.springmappingobjectsex.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
    User findAllByEmail(String email) ;
}
