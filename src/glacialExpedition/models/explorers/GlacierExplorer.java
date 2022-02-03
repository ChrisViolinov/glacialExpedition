package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
    protected static double ENERGY = 40.0;

    public GlacierExplorer(String name) {
        super(name, ENERGY);
        this.setName(name);
    }
}
