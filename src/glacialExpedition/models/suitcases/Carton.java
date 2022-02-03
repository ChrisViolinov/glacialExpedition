package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

import static glacialExpedition.common.ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER;

public class Carton implements Suitcase{

    protected Collection<String> exhibits;

    public Carton(){
        exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String toString(){

        if(exhibits.isEmpty()){
            return "None";
        }
        StringBuilder builder = new StringBuilder();
        for (String exhibit : exhibits) {
            builder.append(exhibit).append(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER);
        }
        return builder.toString();
    }
}
