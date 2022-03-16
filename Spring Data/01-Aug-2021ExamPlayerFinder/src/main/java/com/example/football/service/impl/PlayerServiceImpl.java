package com.example.football.service.impl;

import com.example.football.models.dto.XMLDto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
//ToDo - Implement all methods
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYER_SEED_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;


    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, TownService townService, TeamService teamService, StatService statService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_SEED_PATH));
    }

    @Override
    public String importPlayers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PlayerSeedRootDto playerSeedRootDto = xmlParser.fromFile(PLAYER_SEED_PATH,
                PlayerSeedRootDto.class);
        playerSeedRootDto.getPlayers().stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto);
                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition().name())
                                    : "Invalid Player")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);
                    player.setTown(townService.findTownByName(playerSeedDto.getTown().getName()));
                    player.setTeam(teamService.findTeamByNameGiven(playerSeedDto.getTeam().getName()));
                    player.setStat(statService.findStatById(playerSeedDto.getStat().getId()));
                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers()  {
        StringBuilder string = new StringBuilder();
        List<Player> allByBirthDateBetweenOrderByStatDescLastName = playerRepository.findAllByBirthDateBetweenOrderByStatDescLastName(LocalDate.of(1995,1,1), LocalDate.of(2003,1,1));
       allByBirthDateBetweenOrderByStatDescLastName.forEach(player->
               string.append(String.format("Player - %s %s\n" +
                       "\tPosition - %s\n" +
                       "\tTeam - %s\n" +
                       "\tStadium - %s\n",
                       player.getFirstName(),player.getLastName(),player.getPosition().name(),player.getTeam().getName(),
                       player.getTeam().getStadiumName())));
        return string.toString();
    }
}



