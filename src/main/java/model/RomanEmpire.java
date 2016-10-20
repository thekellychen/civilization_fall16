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

    public String getName() {
        return this.name;
    }

    @Override
    public String explore() {
        int coalFound = this.hills.mineCoal();
        produceResources(coalFound);
        return "You explore your surroundings and acquire "
            + coalFound + " resources!";
    }
}