package exam.service.impl;

import exam.model.dto.TownWrapperDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationTool;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static exam.util.Messages.INVALID_TOWN;
import static exam.util.Messages.TOWN_IMPORTED;
import static exam.util.Paths.PATH_OF_TOWNS;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ValidationTool validationTool, ModelMapper modelMapper) {
        this.townRepository = townRepository;

        this.xmlParser = xmlParser;
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
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PATH_OF_TOWNS, TownWrapperDto.class).getTowns().stream()
                .filter(townDto -> {

                    boolean isValid=validationTool.isValid(townDto);

                    sb.append(isValid?String.format(TOWN_IMPORTED,townDto.getName()):INVALID_TOWN).append(System.lineSeparator());

                    return isValid;

                }).map(townDto -> modelMapper.map(townDto,Town.class)).forEach(townRepository::save);

        return sb.toString();
    }
}
