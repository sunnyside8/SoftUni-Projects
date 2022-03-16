package com.example.springmappingobjectsex.models.dtos;

import com.example.springmappingobjectsex.models.entities.Game;

import java.util.Set;
import java.util.stream.Collectors;

public class UserGamesDto {

    private Set<Game> games;

    public UserGamesDto() {
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return this.games.stream().map(Game::getTitle).collect(Collectors.joining("\n"));
    }
}
