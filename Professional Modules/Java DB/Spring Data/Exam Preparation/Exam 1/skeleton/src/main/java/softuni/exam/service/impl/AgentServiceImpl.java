package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationTool;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static softuni.exam.util.Messages.AGENT_IMPORTED;
import static softuni.exam.util.Messages.INVALID_AGENT;
import static softuni.exam.util.Paths.PATH_OF_AGENT;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationTool validationTool;
    private final TownRepository townRepository;

    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationTool validationTool, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationTool = validationTool;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(PATH_OF_AGENT);
    }

    @Override
    public String importAgents() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentDto[].class))
                .filter(agentDto -> {
                    boolean isValid = validationTool.isValid(agentDto);

                    boolean doesntExist = agentRepository.findAgentByFirstName(agentDto.getFirstName()).isEmpty();

                    if (!doesntExist) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(AGENT_IMPORTED, agentDto.getFirstName(), agentDto.getLastName()) : INVALID_AGENT).append(System.lineSeparator());

                    return isValid;
                }).map(agentDto -> {
                    Agent agent = modelMapper.map(agentDto, Agent.class);
                    agent.setTown(townRepository.findTownByTownName(agentDto.getTown()));
                    return agent;
                }).forEach(agentRepository::save);

        return sb.toString();
    }
}
