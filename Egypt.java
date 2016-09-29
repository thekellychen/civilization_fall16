public class Egypt {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private int numSettlements;
    private Desert desert;

    public Egypt() {
        this.population = new Population();
        this.treasury = new Treasury();
        this.coalMine = new CoalMine();
        this.river = new River("Nile");
        this.technology = new Technology();
        this.strategy = new Strategy();
        this.settlements = new Settlement[10];
        this.numSettlements = 0;
        this.desert = new Desert();
    }

    public Population getPopulation() {
        return this.population;
    }

    public Treasury getTreasury() {
        return this.treasury;
    }

    public CoalMine getCoalMine() {
        return this.coalMine;
    }

    public River getRiver() {
        return this.river;
    }

    public Technology getTechnology() {
        return this.technology;
    }

    public Strategy getStrategy() {
        return this.strategy;
    }

    public boolean settle(Settlement settlement) {
        if (this.numSettlements < settlements.length) {
            settlements[numSettlements] = settlement;
            this.numSettlements++;
            return true;
        }
        return false;
    }

    public int getNumSettlements() {
        return this.numSettlements;
    }

    public Desert getDesert() {
        return this.desert;
    }

    public Settlement[] getSettlements() {
        return this.settlements;
    }

    public boolean buildPyramid(Settlement settlement) {
        if ((this.treasury.getCoins() >= 500)
            && (this.population.getCivilians() >= 100)) {
            this.treasury.spend(500);
            this.population.canWork(100);
            Building pyramid = new Building(500, 100);
            settlement.addBuilding(pyramid);
            this.technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void practiceHieroglyphics() {
        this.technology.improveWriting();
        this.population.increaseHappiness(10);
    }

}