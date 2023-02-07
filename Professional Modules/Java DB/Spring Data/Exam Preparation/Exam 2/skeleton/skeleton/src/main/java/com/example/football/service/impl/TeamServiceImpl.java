package com.example.football.service.impl;

import com.example.football.models.dto.TeamDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationTool;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.football.util.Messages.INVALID_TEAM;
import static com.example.football.util.Messages.TEAM_IMPORTED;
import static com.example.football.util.Paths.PATH_OF_TEAMS;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationTool validationTool;

    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationTool validationTool) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationTool = validationTool;
    }


    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_TEAMS));
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamDto[].class))
                .filter(teamDto -> {

                    boolean isValid = validationTool.isValid(teamDto);
                    boolean isTeamExisting = teamRepository.findTeamByName(teamDto.getName()).isPresent();

                    if (isTeamExisting) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(TEAM_IMPORTED, teamDto.getName(), teamDto.getFanBase()) : INVALID_TEAM).append(System.lineSeparator());

                    return isValid;
                }).map(teamDto -> {
                    Team team = modelMapper.map(teamDto, Team.class);
                    Town town = townRepository.findTownByName(teamDto.getTownName()).orElse(null);
                    team.setTown(town);
                    return team;
                }).forEach(teamRepository::save);


        return sb.toString();
    }
}
