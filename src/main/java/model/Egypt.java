package model;

import java.util.Random;

class Egypt extends Civilization {

    private String name;
    private static Random rand = new Random();
    private Desert desert;

    public Egypt() {
        super();
        this.name = "Egypt";
        this.desert = new Desert();
    }

    public Desert getDesert() {
        return this.desert;
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }

    @Override
    public String explore() {
        getTreasury().earn(this.desert.findTreasure());
        return "You explore your surroundings and acquire "
            + this.desert.findTreasure() + " gold!";
    }
}
