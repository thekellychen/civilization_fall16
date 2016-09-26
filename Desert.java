import java.util.Scanner;
import java.util.Random;

public class Desert {
    private Scanner scan = new Scanner(System.in);
    private int coinAmt;
    private int chanceLost;
    private static Random rand = new Random();

    public Desert() {
        this.coinAmt = 0;
    }

    public int findTreasure() {
        boolean isLost;
        chanceLost = rand.nextInt(10); //10% chance of getting lost
        if (chanceLost == 0) { //0 means lost
            //keep calling lost() until it returns false
            do {
                isLost = lost();
            } while (isLost);
        }
        coinAmt = rand.nextInt(500) + 1;
        return coinAmt;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}