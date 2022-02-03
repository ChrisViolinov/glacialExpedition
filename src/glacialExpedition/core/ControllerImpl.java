package glacialExpedition.core;

import glacialExpedition.models.explorers.*;
import glacialExpedition.models.states.*;
import glacialExpedition.repositories.*;


import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    ExplorerRepository explorers;
    StateRepository states;
    StateRepository exploredStates;

    public ControllerImpl() {
        explorers = new ExplorerRepository();
        states = new StateRepository();
        exploredStates = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorers.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        states.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Object retiring = explorers.byName(explorerName);
        if (retiring == null) {
            throw new IllegalArgumentException(
                    String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        } else {
            explorers.remove(retiring);
            return String.format(EXPLORER_RETIRED, explorerName);
        }
    }

    @Override
    public String exploreState(String stateName) {
        int retiredExplorers=0;
        if(explorers.getCollection().size()<1){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        return String.format(STATE_EXPLORER,stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder builder = new StringBuilder();
        int size = exploredStates.getCollection().size();

        builder.append(String.format(FINAL_STATE_EXPLORED, size))
                .append(System.lineSeparator())
                .append(FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());

        for (Object explorer : explorers.getCollection()) {
            builder.append(explorer.toString());
        }
        return builder.toString().trim();
    }
}
