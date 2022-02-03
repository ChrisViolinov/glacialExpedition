package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static glacialExpedition.common.ExceptionMessages.*;

public class StateImpl implements State{
    protected String name;
    protected Collection<String> exhibits;

    public StateImpl(String name){
        this.setName(name);
        exhibits = new ArrayList<>();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits.stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String getName() {
        return name;
    }
}
