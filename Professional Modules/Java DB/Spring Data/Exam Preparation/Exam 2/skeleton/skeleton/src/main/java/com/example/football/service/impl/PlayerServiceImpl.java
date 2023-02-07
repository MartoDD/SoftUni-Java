package com.example.football.service.impl;

import com.example.football.models.dto.PlayerWrapperDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationTool;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.football.util.Messages.INVALID_PLAYER;
import static com.example.football.util.Messages.PLAYER_IMPORTED;
import static com.example.football.util.Paths.PATH_OF_PLAYERS;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final StatRepository statRepository;
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final LocalDate from = LocalDate.parse("01-01-1995", dateFormatter);
    private final LocalDate to = LocalDate.parse("01-01-2003", dateFormatter);

    public PlayerServiceImpl(PlayerRepository playerRepository, XmlParser xmlParser, ValidationTool validationTool, ModelMapper modelMapper, StatRepository statRepository, TeamRepository teamRepository, TownRepository townRepository) {
        this.playerRepository = playerRepository;
        this.xmlParser = xmlParser;
        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_PLAYERS));
    }

    @Override
    public String importPlayers() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PATH_OF_PLAYERS, PlayerWrapperDto.class).getPlayers().stream()
                .filter(playerDto -> {

                    boolean isValid = validationTool.isValid(playerDto);
                    boolean isPlayerEmailPresent = playerRepository.findPlayerByEmail(playerDto.getEmail()).isPresent();

                    if (isPlayerEmailPresent) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(PLAYER_IMPORTED, playerDto.getFirstName(), playerDto.getLastName(), playerDto.getPosition().toString()) : INVALID_PLAYER).append(System.lineSeparator());

                    return isValid;
                }).map(playerDto -> {
                    Player player = modelMapper.map(playerDto, Player.class);
                    Stat stat = this.statRepository.findById(playerDto.getStat().getId()).orElseThrow(NoSuchElementException::new);
                    Team team = teamRepository.findTeamByName(playerDto.getTeam().getName()).orElse(null);
                    Town town = townRepository.findTownByName(playerDto.getTown().getName()).orElse(null);

                    player.setStat(stat);
                    player.setTown(town);
                    player.setTeam(team);

                    return player;
                }).forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {

        return playerRepository.findByBirthDateBetweenOrderByStat_ShootingDescStat_PassingDescStat_EnduranceDescLastNameAsc(from, to).stream().map(Player::toString).collect(Collectors.joining(System.lineSeparator()));

    }
}
