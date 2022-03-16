package com.example.springmappingobjectsex.services.impls;

import com.example.springmappingobjectsex.models.dtos.GameAddDto;
import com.example.springmappingobjectsex.models.dtos.GameDetailedDto;
import com.example.springmappingobjectsex.models.dtos.GameInfoDto;
import com.example.springmappingobjectsex.models.entities.Game;
import com.example.springmappingobjectsex.repositories.GameRepository;
import com.example.springmappingobjectsex.services.GameService;
import com.example.springmappingobjectsex.services.UserService;
import com.example.springmappingobjectsex.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }


    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (loggedInUserIsEmptyOrNotAdmin()) return;
        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository.save(game);
        System.out.println("Added " + game.getTitle());

    }

    @Override
    public void editGame(Long gameId, List<String> commands) {
        if (loggedInUserIsEmptyOrNotAdmin()) return;
        Game game = getGame(gameId);
        if (gameDoesntExists(game)) return;
        commands.forEach(command -> {
            changeGameParams(game, command);
        });

        Set<ConstraintViolation<Game>> violations = validationUtil.getViolations(game);
        if (gameHasViolations(violations)) return;

        gameRepository.save(game);
        System.out.println("Edited " + game.getTitle());
    }

    @Transactional
    @Override
    public void deleteGame(long gameId) {
        if (loggedInUserIsEmptyOrNotAdmin()) return;
        Game game = getGame(gameId);
        if (gameDoesntExists(game)) return;

        gameRepository.delete(game);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public void printAllGamesInfo() {
        // VARIANT1 this.gameRepository.getAllBy().forEach(System.out::println);
        Set<Game> allGames = this.gameRepository.getBy();
        allGames.stream().map(game -> modelMapper.map(game, GameInfoDto.class))
                .forEach(System.out::println);

    }

    @Override
    public void getDetailedInfoOfAGameByName(String gameName) {
        Game game = gameRepository.getByTitle(gameName).orElse(null);

        if(game == null){
            System.out.println("No game with this title exist in the database");
            return;
        }

        GameDetailedDto gameDetailedDto = modelMapper.map(game,GameDetailedDto.class);
        System.out.println(gameDetailedDto);

    }

    private boolean gameDoesntExists(Game game) {
        if (game == null) {
            System.out.println("The game id is incorrect");
            return true;
        }
        return false;
    }

    private Game getGame(Long gameId) {
        return gameRepository.findById(gameId).orElse(null);
    }

    private boolean gameHasViolations(Set<ConstraintViolation<Game>> violations) {
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return true;
        }
        return false;
    }

    private void changeGameParams(Game game, String command) {
        String parameter = command.split("=")[0];
        String value = command.split("=")[1];

        switch (parameter) {
            case "price" -> game.setPrice(new BigDecimal(value));
            case "title" -> game.setTitle(value);
            case "size" -> game.setSize(Double.parseDouble(value));
            case "trailer" -> game.setTrailer(value);
            case "thumbnailURL" -> game.setImageThumbnail(value);
            case "description" -> game.setDescription(value);
        }
    }

    private boolean loggedInUserIsEmptyOrNotAdmin() {
        if (userService.getLoggedInUser() == null) {
            System.out.println("No user is logged in");
            return true;
        }
        if (!userService.isLoggedUserAdmin()) {
            System.out.println("The logged in user in not an admin");
            return true;
        }
        return false;
    }


}
