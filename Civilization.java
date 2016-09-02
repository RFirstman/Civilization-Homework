import java.util.Scanner;

public class Civilization {
    static boolean playing = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String civ = "";

        while(playing) {
            //Your game code here
            boolean hasChosen = false;
            String[] civArray = new String[4];
            civArray[0] = "American";
            civArray[1] = "Zulu";
            civArray[2] = "English";
            civArray[3] = "Chinese";

            System.out.println("Welcome to Civilization!"
                + "\nPlease choose a civilization!");
            System.out.println("\nCivilizations:\n");
            for (String str : civArray)
                System.out.println(str);

            //Loop to determine if civilization choice is valid
            while (hasChosen == false) {
                System.out.println("\nEnter your civilization:");
                civ = scan.nextLine();

                for (int i = 0; i < 4; i++)
                    if (civ.equalsIgnoreCase(civArray[i]))
                        hasChosen = true;
            }
            System.out.println("You chose the " + civ + " civilization!");

            //Use this to break out of the game loop.
            //Feel free to move it around.
            playing = false;
        }
    }
}
