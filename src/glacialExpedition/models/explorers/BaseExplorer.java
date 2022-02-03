package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public abstract class BaseExplorer implements Explorer {
    protected String name;
    protected double energy;
    protected Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        suitcase = new Carton();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if(energy <0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canSearch() {
        return energy>0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        energy-=15.0;
        if(energy<0){
            canSearch();
            energy=0;
        }
    }
    @Override
    public String toString(){

        return  String.format(FINAL_EXPLORER_NAME, name) +
                System.lineSeparator() +
                String.format(FINAL_EXPLORER_ENERGY, energy) +
                System.lineSeparator() +
                String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,suitcase.toString()) +
                System.lineSeparator();
    }
}
