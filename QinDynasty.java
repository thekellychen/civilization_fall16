public class QinDynasty {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private int numSettlements;
    private Hills hills;

    public QinDynasty() {
        this.population = new Population();
        this.treasury = new Treasury();
        this.coalMine = new CoalMine();
        this.river = new River("Yellow River");
        this.technology = new Technology();
        this.strategy = new Strategy();
        this.settlements = new Settlement[10];
        this.numSettlements = 0;
        this.hills = new Hills();
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

    public Hills getHills() {
        return this.hills;
    }

    public Settlement[] getSettlements() {
        return this.settlements;
    }

    public boolean buildWall(Settlement settlement) {
        if ((this.treasury.getCoins() >= 100)
            && (this.population.getCivilians() >= 100)) {
            this.treasury.spend(100);
            this.population.canWork(100);
            Building wall = new Building(100, 100);
            settlement.addBuilding(wall);
            this.technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildHouse(Settlement settlement) {
        if ((this.treasury.getCoins() >= 30)
            && (this.population.getCivilians() >= 8)) {
            this.treasury.spend(30);
            this.population.canWork(8);
            Building house = new Building(30, 8);
            settlement.addBuilding(house);
            this.technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void establishLegalism() {
        this.technology.philosophize();
        if (this.population.getHappiness() >= 20) {
            this.population.decreaseHappiness(20);
        }
    }
}