import java.util.Scanner; 

public class Civilization {
    static boolean playing = true;
    private static String[] cities = new String[5];
    private static int numAttacks = 0;
    private static double gold = 20.5;
    private static double resources = 30;
    private static int happiness = 10;
    private static int military = 0;
    private static int technology = 0;

    public static void main(String[] args) {
        firstCity();

        while(playing) {
            //Your game code here

            //Use this to break out of the game loop. 
            //Feel free to move it around.
            playing = false;
        }
    }

    public static void firstCity() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Pick a Civilization to lead (Input the corresponding number):\n 1 American (George Washington)\n 2 Zulu (Shaka)\n 3 English (Queen Elizabeth I)\n 4 Chinese (Wu Zetian)");
        int input = scan.nextInt(); 
        scan.nextLine();
        String civ;
        String leader;
        if (input == 1) {
        	civ = "American";
        	leader = "George Washington";
        } else if (input == 2) {
        	civ = "Zulu";
        	leader = "Shaka";
        } else if (input == 3) {
        	civ = "English";
        	leader = "Queen Elizabeth I";
        } else {
        	civ = "Chinese";
        	leader = "Wu Zetian";
        }

    }
}
