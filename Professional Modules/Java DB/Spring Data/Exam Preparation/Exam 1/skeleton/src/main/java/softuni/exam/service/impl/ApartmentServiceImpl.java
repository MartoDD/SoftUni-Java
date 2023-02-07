package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentWrapperDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationTool;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static softuni.exam.util.Messages.APARTMENT_IMPORTED;
import static softuni.exam.util.Messages.INVALID_APARTMENT;
import static softuni.exam.util.Paths.PATH_OF_APARTMENT;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;


    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ValidationTool validationTool, ModelMapper modelMapper, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(PATH_OF_APARTMENT);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();


        xmlParser.fromFile("src/main/resources/files/xml/apartments.xml", ApartmentWrapperDto.class)
                .getApartmentsDto()
                .stream()
                .filter(apartmentDto -> {

                    boolean isValid = validationTool.isValid(apartmentDto);
                    boolean doesNotExist = apartmentRepository.findApartmentByAreaAndTown(apartmentDto.getArea(), findTownByTownName(apartmentDto.getTown())).isEmpty();
                    if (!doesNotExist) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(APARTMENT_IMPORTED, apartmentDto.getApartmentType(), apartmentDto.getArea()) : INVALID_APARTMENT).append(System.lineSeparator());

                    return isValid;

                }).map(apartmentDto -> {
                    Apartment apartment = modelMapper.map(apartmentDto, Apartment.class);
                    apartment.setTown(townRepository.findTownByTownName(apartmentDto.getTown()));

                    return apartment;
                }).forEach(apartmentRepository::save);


        return sb.toString();
    }

    @Override
    public Town findTownByTownName(String name) {
        return townRepository.findTownByTownName(name);
    }


}
