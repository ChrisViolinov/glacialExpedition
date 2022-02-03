package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
    protected static double ENERGY = 100.0;

    public AnimalExplorer(String name) {
        super(name, ENERGY);
        this.setName(name);
    }
}
