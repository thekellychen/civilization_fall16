import java.util.Random;

public class Population {
    private Random rand = new Random();
    private int warriors;
    private int civilians;
    private int happiness;

    public Population() {
        this.warriors = 50;
        this.civilians = 50;
        this.happiness = 200;
    }

    public void increaseHappiness(int happinessAmountInc) {
        this.happiness += happinessAmountInc;
    }

    public void decreaseHappiness(int happinessAmountDec) {
        if (this.happiness - happinessAmountDec > 0) {
            this.happiness -= happinessAmountDec;
        } else {
            this.happiness = 0;
        }
    }

    public boolean canWork(int numWorkersNeeded) {
        if (this.civilians > numWorkersNeeded) {
            this.civilians -= numWorkersNeeded;
            return true;
        }
        return false;
    }

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public Game hunt(Hills hills) {
        return hills.hunt();
    }

    public Fish fish(River river) {
        return river.getFish();
    }

    public boolean canCook(Game game, CoalMine coal) {
        if (coal.getCoal() >= coal.getBurnCost() * 4) {
            for (int i = 0; i < 4; i++) {
                coal.burn();
            }
            this.warriors += 40;
            this.civilians += 60;
            return true;
        }
        return false;
    }

    public boolean canCook(Fish fish, CoalMine coal) {
        if (coal.getCoal() >= coal.getBurnCost() * 4) {
            for (int i = 0; i < 4; i++) {
                coal.burn();
            }
            this.warriors += 10;
            this.civilians += 15;
            return true;
        }
        return false;
    }

    public void setWarriors(int warriors) {
        this.warriors = warriors;
    }

    public int getWarriors() {
        return this.warriors;
    }

    public int getCivilians() {
        return this.civilians;
    }

    public int getHappiness() {
        return this.happiness;
    }
}