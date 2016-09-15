import java.util.Scanner; 

public class Civilization {
    static boolean playing = true;
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
        firstCity();

        while(playing) {
            update();
            displayUpdate();
            System.out.println("It's your turn, pick an action (Input the corresponding number):");
            System.out.println(" 1 Settle a City\n 2 Demolish a City\n 3 Build Militia\n 4 Research Technology\n 5 Attack Enemy City\n 6 End Turn");
            int input = scan.nextInt();
            scan.nextLine();
            if (input == 1) {
            	settleCity();
            } else if (input == 2) {
            	demolishCity();
            } else if (input == 3) {
            	buildMilitia();
            } else if (input == 4) {
            	researchTechnology();
            } else if (input == 5) {
            	attackEnemyCity();
            } else {
            	endTurn();
            }
            //playing = false; moving this line to endTurn()
        }
    }

    public static void firstCity() {
        Scanner scan = new Scanner(System.in); //is it bad that i have this in several different methods
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
        cities[0] = civ; //did I add the city to my array correctly
        cityCount++;
    }

    public static void update() {
    	if (happiness > 20) {
    		resource += (5 * cityCount);
    	} else {
    		resource++;
    	}
    	//System.out.printf("%.2f\n", resource);
    	gold = gold + 3 * cityCount;
    	if (Math.round(resource) % 2 == 0) {
    		happiness++;
    	} else {
    		happiness -= 3;
    	}
    	//System.out.println(resource); System.out.println(happiness); System.out.println(gold);
    }
	
	public static void displayUpdate() {
		System.out.println("Your stock:\nGold: " + gold + "\n" + "Resources: " + resource + "\n" + "Happiness: " + happiness + "\n" + "Military Units: " + military + "\n" + "Technology Points: " + technology + "\n" + "Attacks: " + numAttacks + "\n" + "Cities: " + cityCount + "\n");
	}

	public static void settleCity() {
		Scanner scan = new Scanner(System.in);
		//cant have more than 5 cities
		if (cityCount <= 5) {
			// !!!!!!!!!! need to print out list of cities player already has, dont print out null values (im not sure how to do this yet)
			System.out.println("Name your new city:");
			cityCount++;
			String city = scan.nextLine();
			// !!!!!!!!!! need to add this new city to cities array (did i do this correctly)
			cities[cityCount-1] = city;
			gold -= 15.5;
			if (gold < 0) {
				gold = 0;
			}
		} else {
			System.out.println("Sorry you cannot have more than 5 cities!");
		}
	} 

	public static void demolishCity() {
		//must have at least one city
		if (cityCount == 1) {
			System.out.println("Sorry you must retain at least one city");
		} else {
			System.out.println("Pick a city to demolish");
			// !!!!!!!!!! (1) need to print out list of cities that can be demolished and allow user to pick one (im not sure how to do this yet)
			//!!!!!!!! need to remove demolished city from array. should not leave any nulls/empty strings to be printed out when (1) is executed
			cityCount--;
			resource += 1.5;
		}
	}

	public static void buildMilitia() {
		if ((gold - 5) >= 0 && (resource - 3) >= 0) { //cannot have negative gold or resources
			gold -= 5;
			resource -= 3;
			military++;
		} else if ((gold - 5) < 0) {
			System.out.println("Sorry you don't have enough gold");
		} else if ((resource - 3) < 0) {
			System.out.println("Sorry you don't have enough resources");
		}
	} 

	public static void researchTechnology() {
		if ((gold - 50) >= 0 && (resource - 2) >= 0) { //cannot have negative gold or resources
			gold -= 50;
			resource -= 2;
			technology++;
		} else if ((gold - 50) < 0) {
			System.out.println("Sorry you don't have enough gold");
		} else if ((resource - 2) < 0) {
			System.out.println("Sorry you don't have enough resources");
		}
	}

	public static void attackEnemyCity() { 
		military -= 6;
		happiness -= 3;
		gold += 10;
		if ((military - 6) >= 0) { //cannot have negative military but can have negative happiness
			military -= 6;
			happiness -= 3;
			gold += 10;
		} else {
			System.out.println("Sorry you don't have enough military units");
		} 
	}

	public static void endTurn() {
		//i have to figure this part out but i know it has to do something w the main
		playing = false;
	}
}
