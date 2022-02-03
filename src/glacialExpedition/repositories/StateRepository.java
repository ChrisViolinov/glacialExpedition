package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class StateRepository implements Repository{
    protected Collection<State> states;

    public StateRepository(){

        states = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
        return states.stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Object entity) {
        states.add((State) entity);
    }

    @Override
    public boolean remove(Object entity) {
        for (State state : states) {
            if(state.equals(entity)){
                states.remove(state);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object byName(String name) {
        for (State state : states) {
            if(state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
