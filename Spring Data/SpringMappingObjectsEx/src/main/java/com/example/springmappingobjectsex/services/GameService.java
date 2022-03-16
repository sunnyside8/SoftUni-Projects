package com.example.springmappingobjectsex.services;

import com.example.springmappingobjectsex.models.dtos.GameAddDto;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long id, List<String> commands);

    void deleteGame(long parseLong);

    void printAllGamesInfo();

    void getDetailedInfoOfAGameByName(String command);
}
