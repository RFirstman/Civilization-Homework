import java.util.Scanner;

public class Civilization {
    static boolean playing = true;
    Scanner scan = new Scanner(System.in);

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

            //Use this to break out of the game loop.
            //Feel free to move it around.
            playing = false;
        }


    }

    //Method that takes a string array of civilization choices
    // and takes user input. Also compares the input with the
    // array to ensure valid input.
    public static String chooseCiv(String[] civilizations) {
        boolean hasChosen = false;
        String civ = "";
        Scanner scan = new Scanner(System.in);

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
