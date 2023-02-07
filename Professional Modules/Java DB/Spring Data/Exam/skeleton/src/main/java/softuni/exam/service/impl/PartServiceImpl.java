package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;
import softuni.exam.util.ValidationTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.util.Messages.INVALID_PART;
import static softuni.exam.util.Messages.PART_IMPORTED;
import static softuni.exam.util.Paths.PATH_OF_PARTS;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;
    private final Gson gson;


    public PartServiceImpl(PartRepository partRepository, ValidationTool validationTool, ModelMapper modelMapper, Gson gson) {
        this.partRepository = partRepository;
        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.partRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_PARTS));
    }

    @Override
    public String importParts() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPartsFileContent(), PartDto[].class))
                .filter(partDto -> {
                    boolean isValid = validationTool.isValid(partDto);
                    boolean isPartPresent = partRepository.findPartByPartName(partDto.getPartName()).isPresent();

                    if (isPartPresent) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(PART_IMPORTED, partDto.getPartName(), partDto.getPrice()) : INVALID_PART).append(System.lineSeparator());

                    return isValid;
                }).map(partDto -> modelMapper.map(partDto, Part.class)).forEach(partRepository::save);

        return sb.toString();
    }
}
