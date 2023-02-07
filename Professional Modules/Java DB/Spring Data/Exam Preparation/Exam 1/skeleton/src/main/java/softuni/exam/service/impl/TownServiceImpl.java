package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationTool;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static softuni.exam.util.Messages.INVALID_TOWN;
import static softuni.exam.util.Messages.TOWN_IMPORTED;
import static softuni.exam.util.Paths.PATH_OF_TOWN;

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
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(PATH_OF_TOWN);
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownDto[].class))
                .filter(townDto -> {
                    boolean isValid = validationTool.isValid(townDto);
                    sb.append(isValid ? String.format(TOWN_IMPORTED, townDto.getTownName(), townDto.getPopulation()) : INVALID_TOWN)
                            .append(System.lineSeparator());

                    return isValid;
                }).map(dto -> modelMapper.map(dto, Town.class))
                .forEach(townRepository::save);

        return sb.toString();
    }
}
