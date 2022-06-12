package com.example.demo.repository;


import com.example.demo.model.entity.Artist;
import com.example.demo.model.entity.ArtistEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    Optional<Artist> getCategoryByName(ArtistEnum name);
}
