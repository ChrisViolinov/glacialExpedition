package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExplorerRepository implements Repository {

    protected Collection<Explorer> explorers;

    public ExplorerRepository(){

        explorers = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {

        return explorers.stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Object entity) {
        explorers.add((Explorer) entity);
    }

    @Override
    public boolean remove(Object entity) {
        for (Explorer explorer : explorers) {
            if(explorer.equals(entity)){
                explorers.remove(explorer);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object byName(String name) {
        for (Explorer explorer : explorers) {
            if(explorer.getName().equals(name)){
                return explorer;
            }
        }
        return null;
    }
}
