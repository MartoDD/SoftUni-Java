package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskWrapperDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.models.entity.enums.CarType;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.repository.PartRepository;
import softuni.exam.repository.TaskRepository;
import softuni.exam.service.TaskService;
import softuni.exam.util.ValidationTool;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static softuni.exam.util.Messages.INVALID_TASK;
import static softuni.exam.util.Messages.TASK_IMPORTED;
import static softuni.exam.util.Paths.PATH_OF_TASKS;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MechanicRepository mechanicRepository;
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationTool validationTool;

    public TaskServiceImpl(TaskRepository taskRepository, MechanicRepository mechanicRepository, CarRepository carRepository, PartRepository partRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationTool validationTool) {
        this.taskRepository = taskRepository;
        this.mechanicRepository = mechanicRepository;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationTool = validationTool;
    }


    @Override
    public boolean areImported() {
        return this.taskRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_TASKS));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PATH_OF_TASKS, TaskWrapperDto.class).getTasks().stream()
                .filter(taskDto -> {
                    boolean isValid = validationTool.isValid(taskDto);
                    boolean isMechanicPresent = mechanicRepository.findMechanicByFirstName(taskDto.getMechanicName().getFirstName()).isPresent();

                    if (!isMechanicPresent) {
                        isValid = false;
                    }
                    sb.append(isValid ? String.format(TASK_IMPORTED, taskDto.getPrice()) : INVALID_TASK).append(System.lineSeparator());

                    return isValid;
                }).map(taskDto -> {
                    Task task = modelMapper.map(taskDto, Task.class);
                    Car car = carRepository.getById(taskDto.getCar().getId());
                    Mechanic mechanic = mechanicRepository.findMechanicByFirstName(taskDto.getMechanicName().getFirstName()).orElse(null);
                    Part part = partRepository.getById(taskDto.getPart().getId());
                    task.setCar(car);
                    task.setMechanic(mechanic);
                    task.setPart(part);
                    return task;
                }).forEach(taskRepository::save);

        return sb.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        return this.taskRepository.findTasksByCar_CarTypeOrderByPriceDesc(CarType.coupe).stream().map(Task::toString).collect(Collectors.joining(System.lineSeparator()));

    }
}
