import java.util.Scanner;
import java.util.Random;

public class Desert {
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    private boolean isLost;

    public int findTreasure() {
        // YOUR CODE HERE
        // A valid treasure trove must be greater than 0
        isLost = false;
        if (rand.nextInt(10) == 0) {
            while (isLost) {
                if (!lost()) {
                    isLost = false;
                }
            }
        }
        return 1 + rand.nextInt(500);
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}