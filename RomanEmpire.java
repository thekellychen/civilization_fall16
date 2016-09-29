public class RomanEmpire {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private int numSettlements;
    private Hills hills;

    public RomanEmpire() {
        this.population = new Population();
        this.treasury = new Treasury();
        this.coalMine = new CoalMine();
        this.river = new River("Tiber");
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

    public boolean buildAqueduct(Settlement settlement) {
        if ((this.treasury.getCoins() >= 250)
            && (this.population.getCivilians() >= 130)) {
            this.treasury.spend(250);
            this.population.canWork(130);
            Building aqueduct = new Building(250, 130);
            settlement.addBuilding(aqueduct);
            this.technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildBathHouse(Settlement settlement) {
        if ((this.treasury.getCoins() >= 110)
            && (this.population.getCivilians() >= 20)) {
            this.treasury.spend(110);
            this.population.canWork(20);
            Building bathHouse = new Building(110, 20);
            settlement.addBuilding(bathHouse);
            this.technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildVilla(Settlement settlement) {
        if ((this.treasury.getCoins() >= 80)
            && (this.population.getCivilians() >= 15)) {
            this.treasury.spend(80);
            this.population.canWork(15);
            Building villa = new Building(80, 15);
            settlement.addBuilding(villa);
            this.technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void studyPhilosophy() {
        if (this.population.getHappiness() >= 10) {
            this.population.decreaseHappiness(10);
            this.technology.philosophize();
        }
    }
}