import java.util.Random;

public class Population {
    private Random rand = new Random();

    private int warriors, civilians, happiness;

    public Population() {
        warriors = 50;
        civilians = 50;
        happiness = 200;
    }

    public void increaseHappiness(int happiness) {
        this.happiness += happiness;
    }

    public void decreaseHappiness(int happiness) {
        this.happiness -= happiness;
    }

    public boolean canWork(int workersNeeded) {
        if (civilians >= workersNeeded) {
            civilians -= workersNeeded;
            return true;
        } else {
            return false;
        }
    }

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public Game hunt(Hills hills) {
        return hills.hunt();
    }

    public Fish fish(River river) {
        return river.fish();
    }

    public boolean canCook(Game game, CoalMine mine) {
        if (mine.getCoal() >= 40) {
            for (int i = 0; i < 4; i++) {
                mine.burn();
            }
            warriors += 40;
            civilians += 60;
        }
    }

    public boolean canCook(Fish fish, CoalMine mine) {
        if (mine.getCoal() >= 40) {
            for (int i = 0; i < 4; i++) {
                mine.burn();
            }
            warriors += 10;
            civilians += 15;
        }
    }
}