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
        super.getHills().replenishGame();

        int tempGame = super.getHills.hunt();
        super.makeFood(tempGame.getHealth());

        return "You have hunted in your hills and have made"
            + tempGame.getHealth() + " food!"
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowerUnit(this);
    }

}
