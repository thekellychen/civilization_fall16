public class Game {
    private int healthIncrease;

    public Game(int health) {
        this.healthIncrease = healthIncrease;
    }

    public Game() {
        this(20);
    }

    public int getHealth() {
        return healthIncrease;
    }
}