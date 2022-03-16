package com.example.springmappingobjectsex.repositories;

import com.example.springmappingobjectsex.models.dtos.GameInfoDto;
import com.example.springmappingobjectsex.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT new com.example.springmappingobjectsex.models.dtos.GameInfoDto(games.title,games.price) " +
            "FROM games games")
    Set<GameInfoDto> getAllBy();

    Set<Game> getBy();

    Optional<Game> getByTitle(String title);
}
