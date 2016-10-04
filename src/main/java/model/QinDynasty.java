package model;
import java.util.Random;

class QinDynasty extends Civilization {

    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        this.getHills().replenishGame();

        Game tempGame = this.getHills().hunt();
        this.makeFood(tempGame.getHealth());

        return "You have hunted in your hills and have made"
            + tempGame.getHealth() + " food!";
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }

}
