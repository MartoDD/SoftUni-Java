package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int count;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;

        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        List<String> allExhibits = Arrays.stream(exhibits).collect(Collectors.toList());

        State state = new StateImpl(stateName);
        state.getExhibits().addAll(allExhibits);
        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        if (explorerRepository.byName(explorerName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        Explorer explorer = explorerRepository.byName(explorerName);
        explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorers = explorerRepository.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (explorers.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        MissionImpl mission = new MissionImpl();
        State state = stateRepository.byName(stateName);
        mission.explore(state, explorers);
        count++;
        long retiredExplorers = explorers.stream().filter(e -> e.getEnergy() == 0).count();
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {

        return String.format(ConstantMessages.FINAL_STATE_EXPLORED, count) + System.lineSeparator() +
                ConstantMessages.FINAL_EXPLORER_INFO + System.lineSeparator() +
                explorerRepository.getCollection().stream().map(explorer -> String.format(ConstantMessages.FINAL_EXPLORER_NAME,explorer.getName()) + System.lineSeparator()
                        + String.format(ConstantMessages.FINAL_EXPLORER_ENERGY,explorer.getEnergy()) + System.lineSeparator()
                        + "Suitcase exhibits: " + (explorer.getSuitcase().getExhibits().size() != 0 ?
                        String.join(", ", explorer.getSuitcase().getExhibits()) : "None")).collect(Collectors.joining(System.lineSeparator()));
    }
}
