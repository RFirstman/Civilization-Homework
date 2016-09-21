import java.util.Random;

public class River {
    private static Random rand = new Random();

    private String name;
    private Fish[] fish;
    private int numFish = 0;

    public River(String name) {
        this.name = name

        fish = new Fish[5];
        numFish = 0;
        replenishFish();
    }

    public String getName() {
        return name;
    }

    public Fish getFish() {
        Fish fished;

        if (numFish > 0) {
            fished = fish[--numFish];
            fish[numFish] = null;
        } else {
            fished = null;
        }
        return fished;
    }

    public boolean replenishFish() {
        if (numFish == 0) {
            for (int = 0; i < fish.length; i++) {
                fish[i] = new Fish(rand.nextInt(5));
            }
            numFish = fish.length;
            return true;
        }
        return false;
    }

}