package com.example.football.service.impl;

import com.example.football.models.dto.StatDto;
import com.example.football.models.dto.StatWrapperDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationTool;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.football.util.Messages.INVALID_STAT;
import static com.example.football.util.Messages.STAT_IMPORTED;
import static com.example.football.util.Paths.PATH_OF_STATS;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ValidationTool validationTool, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_STATS));
    }

    @Override
    public String importStats() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PATH_OF_STATS, StatWrapperDto.class).getStats().stream()
                .filter(statDto -> {

                    boolean isValid = validationTool.isValid(statDto);
                    boolean isStatPresent = statRepository.findStatByShootingAndEnduranceAndPassing(statDto.getShooting(), statDto.getEndurance(), statDto.getPassing()).isPresent();

                    if (isStatPresent) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(STAT_IMPORTED, statDto.getShooting(), statDto.getPassing(), statDto.getEndurance()) : INVALID_STAT).append(System.lineSeparator());

                    return isValid;

                }).map(statDto -> modelMapper.map(statDto, Stat.class)).forEach(statRepository::save);

        return sb.toString();
    }
}
