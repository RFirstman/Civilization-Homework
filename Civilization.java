import java.util.Scanner;
import java.text.DecimalFormat;

public class Civilization {
    static boolean playing = true;
    static Scanner scan = new Scanner(System.in);
    static String[] cityArray = new String[5];
    static int atttacks = 0, militaryUnits = 0, techPoints = 0;
    static int happiness = 10, numCities = 0;
    static double gold = 20, resources = 30;
    static Civilization civObj = new Civilization();
    static DecimalFormat decimalFormat = new DecimalFormat("###.0#");
    static String[] civArray = {"American", "Zulu", "English",
    "Chinese"};
    static String[] choiceArray = {"Settle a City", "Demolish a City",
    "Build Militia", "Research Technology", "Attack Enemy City", "End Turn"};


    public static void main(String[] args) {

        while(playing) {
            //Your game code here

            System.out.println("Welcome to Civilization!");

            String userCiv = chooseCiv(civArray);

            System.out.println("You have chosen the " + userCiv
                + " civilization!");
            System.out.println("\nWhat will your first city's name be?");
            cityArray[0] = scan.nextLine();
            numCities++;
            civObj.displayStatus();

            //Use this to break out of the game loop.
            //Feel free to move it around.
            playing = false;
        }


    }

    //Method that displays all resources, properties, and cities
    public static void displayStatus() {
        System.out.println("\nStatus"
            + "\nResources:\t\t" + decimalFormat.format(resources)
            + "\nGold:\t\t\t" + decimalFormat.format(gold)
            + "\nMilitary Units\t\t" + militaryUnits
            + "\nHappiness\t\t" + happiness
            + "\nTechnology Points\t" + techPoints);

        System.out.println("\nCities:");
        for (int i = 0; i < cityArray.length; i++)
            if (cityArray[i] != null)
                System.out.println("\t" + cityArray[i]);
    }

    //Method that takes a string array of civilization choices
    // and takes user input. Also compares the input with the
    // array to ensure valid input.
    public static String chooseCiv(String[] civilizations) {
        boolean hasChosen = false;
        String civ = "";
        //Scanner scan = new Scanner(System.in);

        System.out.println("Please choose a civilization."
            + "\nCivilizations:\n");
        for (String str : civilizations)
            System.out.println(str);

        while (hasChosen == false) {
            System.out.println("\nEnter your civilization:");
            civ = scan.nextLine();

            for (int i = 0; i < civilizations.length; i++)
                if (civ.equalsIgnoreCase(civilizations[i]))
                        hasChosen = true;
        }
        return civ;
    }

    //Adds per-turn resources/happiness/gold to user's total
    public static void nextTurn() {
        resources++;
        if (happiness > 20)
            resources = resources + 5*numCities;
        gold = gold + 3*numCities;
        if (happiness % 2 == 0)
            happiness++;
        else
            happiness = happiness - 3;
    }

    //Settles a new city
    public static void settleCity() {
        System.out.println("\nCities:");
        for (int i = 0; i < cityArray.length; i++)
            if (cityArray[i] != null)
                System.out.println("\t" + cityArray[i]);
        if (numCities < 5) {
            for (int i = 0; i < 5; i++)
                if (cityArray[i] != null) {
                 System.out.println("What would you like to name your city?");
                 civArray[i] = scan.nextLine();
                 System.out.println("You have settled " + civArray[i] + "!");
                }
            numCities++;
            gold -= 15.5;
        }
        else
            System.out.println("You have too many cities.");
    }
}
