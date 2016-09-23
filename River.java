import java.util.Random;

public class River {
    private Fish[] fishes;
    private String name;
    private int fishCount;
    private Fish fishy;
    private boolean replenish;

    private static Random rand = new Random();

    public River(String name) {
        this.name = name;
        this.fishes = new Fish[5];
        for (int i = 0; i < 5; i++) {
            this.fishes[i] = new Fish(rand.nextInt(5));
        }
        this.fishCount = fishes.length;
    }

    public Fish getFish() {
        if (fishCount > 0) {
            fishy = fishes[fishCount - 1];
            fishes[fishCount - 1] = null;
            fishCount--;
        } else {
            fishy = null;
        }
        return fishy;
    }

    public boolean replenishFish() {
        if (fishCount <= 0) {
            for (int i = 0; i < 5; i++) {
                fishes[i] = new Fish(rand.nextInt(5));
            }
            replenish = true;
            fishCount = fishes.length;
        } else {
            replenish = false;
        }
        return replenish;
    }

    public String getName() {
        return this.name;
    }
}