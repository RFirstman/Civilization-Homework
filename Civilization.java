import java.util.Scanner;

public class Civilization {
    static boolean playing = true;
    static Scanner scan = new Scanner(System.in);
    static String[] cityArray = new String[20];
    static int atttacks = 0, militaryUnits = 0, techPoints = 0, happiness = 10;
    static double gold = 20.5, resources = 30;
    static Civilization status = new Civilization();


    public static void main(String[] args) {

        while(playing) {
            //Your game code here
            String[] civArray = new String[4];
            civArray[0] = "American";
            civArray[1] = "Zulu";
            civArray[2] = "English";
            civArray[3] = "Chinese";

            System.out.println("Welcome to Civilization!");

            String userCiv = chooseCiv(civArray);

            System.out.println("You have chosen the " + userCiv
                + " civilization!");
            System.out.println("\nWhat will your first city's name be?");
            cityArray[0] = scan.nextLine();
            status.displayStatus();

            //Use this to break out of the game loop.
            //Feel free to move it around.
            playing = false;
        }


    }

    //Method that displays all resources, properties, and cities
    public static void displayStatus() {
        System.out.println("\nStatus"
            + "\nResources:\t\t" + resources
            + "\nGold:\t\t\t" + gold
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

            for (int i = 0; i < 4; i++)
                if (civ.equalsIgnoreCase(civilizations[i]))
                        hasChosen = true;
        }
        return civ;
    }

}
