import java.util.Scanner;

public class Civilization {
    private static boolean playing = true;
    private static String[] cities = new String[5];
    private static int numAttacks = 0;
    private static double gold = 20.5;
    private static double resource = 30;
    private static int happiness = 10;
    private static int military = 0;
    private static int technology = 0;
    private static int cityCount = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        firstCity(scan);

        while (playing) {
            update();
            displayUpdate();
            System.out.println("It's your turn, pick an action (Input the corresponding number):");
            System.out.println(" 1 Settle a City\n 2 Demolish a City\n 3 Build Militia\n 4 Research Technology\n 5 Attack Enemy City\n 6 End Turn");
            int input = scan.nextInt();
            scan.nextLine();
            if (input == 1) {
            	settleCity(scan);
            } else if (input == 2) {
            	demolishCity(scan);
            } else if (input == 3) {
            	buildMilitia();
            } else if (input == 4) {
            	researchTechnology();
            } else if (input == 5) {
            	attackEnemyCity();
            } else {
            	endTurn();
            }
            if (technology == 20 || numAttacks == 10) {
            	playing = false;
            }
        }
        System.out.println("Game over.");
    }

    public static void firstCity(Scanner scan) {
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
        cities[0] = civ;
        cityCount++;
    }

    public static void update() {
    	if (happiness > 20) {
            resource += (5 * cityCount);
    	} else {
            resource++;
    	}
    	gold = gold + 3 * cityCount;
    	if (Math.round(resource) % 2 == 0) {
            happiness++;
    	} else {
            happiness -= 3;
    	}
    }

    public static void displayUpdate() {
        System.out.println("\nYour stock:\nGold: " + gold + "\n" + "Resources: " + resource + "\n" + "Happiness: " + happiness + "\n" + "Military Units: " + military + "\n" + "Technology Points: " + technology + "\n" + "Attacks: " + numAttacks + "\n" + "Cities: " + cityCount + "\n");
    }

    public static void settleCity(Scanner scan) {
		//cant have more than 5 cities
        if (cityCount < 5 && gold >= 15.5) {
            System.out.println("These are your cities:");
            for (int i = 0; i < cityCount; i++) {
                System.out.println(cities[i]);
            }
            System.out.println("Name your new city:");
            cityCount++;
            String city = scan.nextLine();
            cities[cityCount - 1] = city;
            gold -= 15.5;
            if (gold < 0) {
                gold = 0;
            }
            System.out.println("\nYou now have a new city called " + city + ".");
        } else {
            System.out.println("\nSorry you cannot settle this city! End of turn.");
        }
    }

    public static void demolishCity(Scanner scan) {
        if (cityCount == 1) {
            System.out.println("\nSorry you must retain at least one city. End of turn.");
        } else {
            System.out.println("Pick a city to demolish");
            for (int i = 0; i < cityCount; i++) {
                System.out.println(i + ". " + cities[i]);
            }
            System.out.println("Input the corresponding number for the city you want to demolish:");
            int input = scan.nextInt();
            scan.nextLine();
            cities[input] = cities[cityCount - 1];
            cityCount--;
            resource += 1.5;
            String city;
            if (input == 0) {
                city = cities[0];
            } else if (input == 1) {
                city = cities[1];
            } else if (input == 2) {
                city = cities[2];
            } else if (input == 3) {
                city = cities[3];
            } else {
                city = cities[4];
            }
            System.out.println("\nYou have demolished " + city + ".");
        }
    }

    public static void buildMilitia() {
        if ((gold - 5) >= 0 && (resource - 3) >= 0) { //cannot have negative gold or resources
            gold -= 5;
            resource -= 3;
            military++;
            System.out.println("\nYou now have " + military + " military units.");
        } else if ((gold - 5) < 0) {
            System.out.println("\nSorry you don't have enough gold. End of turn.");
        } else if ((resource - 3) < 0) {
            System.out.println("\nSorry you don't have enough resources. End of turn.");
        }
    }

    public static void researchTechnology() {
        if ((gold - 50) >= 0 && (resource - 2) >= 0) { //cannot have negative gold or resources
            gold -= 50;
            resource -= 2;
            technology++;
            System.out.println("\nYou now have " + technology + " technology points.");
        } else if ((gold - 50) < 0) {
            System.out.println("\nSorry you don't have enough gold. End of turn.");
        } else if ((resource - 2) < 0) {
            System.out.println("\nSorry you don't have enough resources. End of turn.");
        }
    }

    public static void attackEnemyCity() {
        if ((military - 6) >= 0) { //cannot have negative military but can have negative happiness
            military -= 6;
            happiness -= 3;
            gold += 10;
            numAttacks++;
            System.out.println("\nYou attacked an enemy city.");
        } else {
            System.out.println("\nSorry you don't have enough military units. End of turn.");
        }
    }

    public static void endTurn() {
        System.out.println("You just ended your turn.");
    }
}
