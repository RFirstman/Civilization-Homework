package model;

public class Coliseum extends Landmark {

    public Coliseum(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        this.getOwner().increaseHappiness(50);
        super.invest();
    }
}