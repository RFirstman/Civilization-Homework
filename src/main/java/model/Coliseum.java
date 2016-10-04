package model;

public class Coliseum extends Landmark {

    private boolean hasInvested = false;

    public Coliseum(Civilzation owner) {
        super(owner);
    }

    @Override
    public void invest() {
        if (!hasInvested) {
            this.getOwner().increaseHappiness(50);
        }
    }
}