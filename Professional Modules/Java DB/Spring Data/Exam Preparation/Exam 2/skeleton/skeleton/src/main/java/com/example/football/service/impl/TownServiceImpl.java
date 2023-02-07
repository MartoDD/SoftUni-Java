package com.example.football.service.impl;

import com.example.football.models.dto.TownDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationTool;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.football.util.Messages.INVALID_TOWN;
import static com.example.football.util.Messages.TOWN_IMPORTED;
import static com.example.football.util.Paths.PATH_OF_TOWNS;


@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;


    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationTool validationTool, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_TOWNS));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownDto[].class)).filter(town -> {
                    boolean isValid = validationTool.isValid(town);
                    boolean isTownPresent = townRepository.findTownByName(town.getName()).isPresent();

                    if (isTownPresent) {
                        isValid = false;
                    }
                    sb.append(isValid ? String.format(TOWN_IMPORTED, town.getName(), town.getPopulation()) : INVALID_TOWN).append(System.lineSeparator());

                    return isValid;
                }).map(townDto -> modelMapper.map(townDto,Town.class))
                .forEach(townRepository::save);
        return sb.toString();
    }
}
