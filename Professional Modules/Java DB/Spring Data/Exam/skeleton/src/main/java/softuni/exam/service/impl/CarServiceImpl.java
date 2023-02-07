package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarWrapperDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationTool;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.util.Messages.CAR_IMPORTED;
import static softuni.exam.util.Messages.INVALID_CAR;
import static softuni.exam.util.Paths.PATH_OF_CARS;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationTool validationTool;

    public CarServiceImpl(CarRepository carRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationTool validationTool) {
        this.carRepository = carRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationTool = validationTool;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_OF_CARS));
    }

    @Override
    public String importCars() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PATH_OF_CARS, CarWrapperDto.class).getCars().stream()
                .filter(carDto -> {
                    boolean isValid = validationTool.isValid(carDto);
                    boolean isPlateNumberPresent = carRepository.findCarByPlateNumber(carDto.getPlateNumber()).isPresent();

                    if (isPlateNumberPresent) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(CAR_IMPORTED, carDto.getCarMake(), carDto.getCarModel()) : INVALID_CAR).append(System.lineSeparator());

                    return isValid;
                }).map(carDto -> modelMapper.map(carDto, Car.class)).forEach(carRepository::save);

        return sb.toString();
    }
}
