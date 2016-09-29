public class Strategy {
    private int strategyLevel;
    private boolean conqueredTheWorld;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;

    public Strategy() {
        this.strategyLevel = 0;
        this.conqueredTheWorld = false;
    }

    public void battle() {
        strategyLevel += BATTLE_INCREASE;
        if (strategyLevel > 180) {
            conqueredTheWorld = true;
        }
    }

    public void siege() {
        strategyLevel += SIEGE_INCREASE;
        if (strategyLevel > 180) {
            conqueredTheWorld = true;
        }
    }

    public boolean conqueredTheWorld() {
        return (conqueredTheWorld);
    }

    public int getStrategyLevel() {
        return this.strategyLevel;
    }
}