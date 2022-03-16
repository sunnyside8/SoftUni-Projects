package com.example.springmappingobjectsex;

import com.example.springmappingobjectsex.models.dtos.GameAddDto;
import com.example.springmappingobjectsex.models.dtos.UserLoginDto;
import com.example.springmappingobjectsex.models.dtos.UserRegisterDto;
import com.example.springmappingobjectsex.services.GameService;
import com.example.springmappingobjectsex.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;


    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {

        while(true){
            System.out.println("Enter your commands or END to end the program");
            String [] commands  = bufferedReader.readLine().split("\\|");

            switch (commands[0]){
                case "RegisterUser" -> userService
                        .registerUser(new UserRegisterDto(commands[1],commands[2],commands[3],commands[4] ));
                case "LoginUser" -> userService.loginUser(new UserLoginDto(commands[1],commands[2] ));
                case"Logout" -> userService.logout();
                case"AddGame" -> gameService.addGame(new GameAddDto(commands[1],new BigDecimal(commands[2]),Double.parseDouble(commands[3]),
                        commands[4],commands[5],commands[6], LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                case"EditGame" -> gameService.editGame(Long.parseLong(commands[1]),Arrays.stream(commands).skip(2).collect(Collectors.toList()));

                case"DeleteGame" -> gameService.deleteGame(Long.parseLong(commands[1]));

                case"AllGames" -> gameService.printAllGamesInfo();
                case"DetailGame" -> gameService.getDetailedInfoOfAGameByName(commands[1]);
                case"OwnedGames" -> userService.printOwnedGames();
                case "END" -> {
                    return;
                }
                default -> System.out.println("Please enter valid command!");
            }
        }
    }
}
