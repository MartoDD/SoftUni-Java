package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;
import softuni.exam.util.ValidationTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.util.Messages.INVALID_MECHANIC;
import static softuni.exam.util.Messages.MECHANIC_IMPORTED;
import static softuni.exam.util.Paths.PATH_OF_MECHANICS;

@Service
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;
    private final ValidationTool validationTool;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public MechanicServiceImpl(MechanicRepository mechanicRepository, ValidationTool validationTool, Gson gson, ModelMapper modelMapper) {
        this.mechanicRepository = mechanicRepository;
        this.validationTool = validationTool;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.mechanicRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_OF_MECHANICS));
    }

    @Override
    public String importMechanics() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicDto[].class))
                .filter(mechanicDto -> {
                    boolean isValid = validationTool.isValid(mechanicDto);
                    boolean isEmailPresent = mechanicRepository.findMechanicByEmail(mechanicDto.getEmail()).isPresent();
                    boolean isFirstNamePresent = mechanicRepository.findMechanicByFirstName(mechanicDto.getFirstName()).isPresent();
                    boolean isPhonePresent = mechanicRepository.findMechanicByPhone(mechanicDto.getPhone()).isPresent();

                    if (isEmailPresent || isFirstNamePresent || isPhonePresent) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(MECHANIC_IMPORTED, mechanicDto.getFirstName(), mechanicDto.getLastName()) : INVALID_MECHANIC).append(System.lineSeparator());

                    return isValid;
                }).map(mechanicDto -> modelMapper.map(mechanicDto, Mechanic.class)).forEach(mechanicRepository::save);

        return sb.toString();
    }
}
