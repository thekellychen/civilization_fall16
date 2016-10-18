package model;

import java.util.Random;

class RomanEmpire extends Civilization {

    private String name;
    private static Random rand = new Random();
    private Hills hills;

    public RomanEmpire() {
        super();
        this.name = "Roman Empire";
        this.hills = new Hills();
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }

    @Override
    public String explore() {
        produceResources(this.hills.mineCoal());
        return "You explore your surroundings and acquire "
            + this.hills.mineCoal() + " resources!";
    }
}