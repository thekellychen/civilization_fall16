package model;

import java.util.Random;

class QinDynasty extends Civilization {

    private String name;
    private static Random rand = new Random();
    private Hills hills;

    public QinDynasty() {
        super();
        this.name = "Qin Dynasty";
        this.hills = new Hills();
    }

    public Hills getHills() {
        return this.hills;
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }

    @Override
    public String explore() {
        Game gameFound = this.hills.hunt();
        if (gameFound == null) {
            this.hills.replenishGame();
            gameFound = this.hills.hunt();
        }
        makeFood(gameFound.getHealth());
        return "You explore your surroundings and acquire "
            + gameFound.getHealth() + " food!";
    }
}