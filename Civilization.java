import java.util.Scanner;
import java.text.DecimalFormat;

//To-do: Implement a turn and action selection system.
public class Civilization {
    static boolean playing = true;
    static Scanner scan = new Scanner(System.in);
    static String[] cityArray = new String[5];
    static int attacks = 0, militaryUnits = 0, techPoints = 0;
    static int happiness = 10, numCities = 0, turn = 0;
    static double gold = 20, resources = 30;
    static Civilization civObj = new Civilization();
    static DecimalFormat decimalFormat = new DecimalFormat("###.00");
    static String[] civArray = {"American", "Zulu", "English",
        "Chinese"};
    static String[] choiceArray = {"Settle a City", "Demolish a City",
        "Build Militia", "Research Technology", "Attack Enemy City",
        "End Turn"};


    public static void main(String[] args) {

        //Starts the game, asks user to choose civilization and to name
        // his/her first city
        System.out.println("Welcome to Civilization!");

        String userCiv = chooseCiv(civArray);

        System.out.println("You have chosen the " + userCiv
            + " civilization!");
        System.out.println("\nWhat will your first city's name be?");
        cityArray[0] = scan.nextLine();
        numCities++;

        while (playing) {
            //Your game code here
            civObj.turn();

            if (techPoints == 20) {
                System.out.println("You have reached 20 Technology Points!");
                System.out.println("You win!");
                playing = false;
            } else if (attacks == 10) {
                System.out.println("You have destroyed the enemy city!");
                System.out.println("You win!");
                playing = false;
            }
        }


    }

    //Method to handle all turn-related actions
    public static void turn() {
        boolean hasntChosen = true;
        String choice = "";

        //Adds per-turn resources, gold, and happiness
        if (turn != 0) {
            resources++;
            if (happiness > 20) {
                resources = resources + (5 * numCities);
            }
            gold = gold + (3 * numCities);
            if (happiness % 2 == 0) {
                happiness++;
            } else {
                happiness = happiness - 3;
            }
        }

        //Takes action input and ensures that it is valid
        System.out.println("\nTurn " + turn);
        civObj.displayStatus();
        System.out.println("\nWhat would you like to do this turn?");
        for (String str : choiceArray) {
            System.out.println("\n" + str);
        }

        while (hasntChosen) {
            System.out.println("\nChoose an action.");
            choice = scan.nextLine();

            for (int i = 0; i < choiceArray.length; i++) {
                if (choice.equalsIgnoreCase(choiceArray[i])) {
                    hasntChosen = false;
                }
            }
        }

        //Calls corresponding method for the user's choice
        // or increments turn if user chooses "End Turn"
        if (choice.equalsIgnoreCase(choiceArray[0])) {
            civObj.settleCity();
        } else if (choice.equalsIgnoreCase(choiceArray[1])) {
            civObj.demolishCity();
        } else if (choice.equalsIgnoreCase(choiceArray[2])) {
            civObj.buildMilitia();
        } else if (choice.equalsIgnoreCase(choiceArray[3])) {
            civObj.researchTechnology();
        } else if (choice.equalsIgnoreCase(choiceArray[4])) {
            civObj.attackCity();
        } else {
            turn++;
        }
    }

    //Method that displays all resources, properties, and cities
    public static void displayStatus() {
        System.out.println("\nTurn " + turn + " Status"
            + "\nResources:\t\t" + decimalFormat.format(resources)
            + "\nGold:\t\t\t" + decimalFormat.format(gold)
            + "\nMilitary Units\t\t" + militaryUnits
            + "\nHappiness\t\t" + happiness
            + "\nTechnology Points\t" + techPoints);

        System.out.println("\nCities:");
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i] != null) {
                System.out.println("\t" + cityArray[i]);
            }
        }
    }

    //Method that takes a string array of civilization choices
    // and takes user input. Also compares the input with the
    // array to ensure valid input.
    public static String chooseCiv(String[] civilizations) {
        boolean hasntChosen = true;
        String civ = "";
        //Scanner scan = new Scanner(System.in);

        System.out.println("\nPlease choose a civilization."
            + "\nCivilizations:\n");
        for (String str : civilizations) {
            System.out.println(str);
        }

        while (hasntChosen) {
            System.out.println("\nEnter your civilization:");
            civ = scan.nextLine();

            for (int i = 0; i < civilizations.length; i++) {
                if (civ.equalsIgnoreCase(civilizations[i])) {
                    hasntChosen = false;
                }
            }
        }
        return civ;
    }


    //Settles a new city
    public static void settleCity() {
        //Displays a list of cities
        System.out.println("\nCities:");
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i] != null) {
                System.out.println("\t" + cityArray[i]);
            }
        }
        //Ensures the user has at least one slot for a city
        if (gold >= 15.5) {
            if (numCities < 5) {
                for (int i = 0; i < 5; i++) {
                    if (cityArray[i] == null) {
                        System.out.println("\nWhat would you like to name your "
                            + "city?");
                        cityArray[i] = scan.nextLine();
                        System.out.println("You have settled " + cityArray[i]
                            + "!");
                        break;
                    }
                }
                numCities++;
                gold -= 15.5;
            } else {
                System.out.println("\nYou have too many cities.");
            }
        } else {
            System.out.println("\nInsufficient Gold.");
        }

        turn++;
    }

    //Demolishes a city
    public static void demolishCity() {
        boolean hasntChosen = true;
        String city = "a";

        //Ensures that the player has enough cities to demolish one
        if (numCities > 1) {
            System.out.println("\nCities:");
            for (int i = 0; i < cityArray.length; i++) {
                if (cityArray[i] != null) {
                    System.out.println("\t" + cityArray[i]);
                }
            }

            //Ensure city input is valid
            while (hasntChosen) {
                System.out.println("\nChoose a city to demolish:");
                city = scan.nextLine();

                for (int i = 0; i < cityArray.length; i++) {
                    if (city.equalsIgnoreCase(cityArray[i])) {
                        hasntChosen = false;
                    }
                }
            }

            //Reads through cityArray to find the city to delete.
            for (int i = 0; i < cityArray.length; i++) {
                if (city.equalsIgnoreCase(cityArray[i])) {
                    System.out.println("You have destroyed " + city);
                    cityArray[i] = null;
                }
            }
            numCities--;
            resources += 1.5;
        } else {
            System.out.println("\nYou do not have enough cities.");
        }

        turn++;
    }

    //Spends 5 gold and 3 resources to build another military unit
    public static void buildMilitia() {
        if (gold >= 5 && resources >= 3) {
            militaryUnits++;
            gold -= 5;
            resources -= 3;
            System.out.println("\nYou have expanded your military!");
        } else {
            System.out.println("\nYou lack sufficient materials.");
        }

        turn++;
    }

    //Spends 50 gold and 2 resources to receive one Technology Point
    public static void researchTechnology() {
        if (gold >= 50 && resources >= 2) {
            techPoints++;
            gold -= 50;
            resources -= 2;
            System.out.println("\nYou have gained a Technology Point!");
        } else {
            System.out.println("\nYou lack sufficient materials.");
        }

        turn++;
    }

    //Spends 6 military units and 3 happiness to attack an enemy city
    public static void attackCity() {
        if (militaryUnits >= 6) {
            attacks++;
            militaryUnits -= 6;
            happiness -= 3;
            System.out.println("\nYou have attacked an enemy city!");
        } else {
            System.out.println("\nYou lack sufficient materials.");
        }

        turn++;
    }
}
