package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {


    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        List<String> exhibits = new ArrayList<>(state.getExhibits());

        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && exhibits.size() != 0) {
                explorer.search();
                String exhibit = exhibits.get(0);
                explorer.getSuitcase().getExhibits().add(exhibit);
                exhibits.remove(0);
            }
        }

    }
}
