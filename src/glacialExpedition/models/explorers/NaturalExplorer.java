package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    protected static double ENERGY = 60.0;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
        this.setName(name);

    }

    @Override
    public void search() {
        ENERGY -= 7;
    }
}
