package model;

public class Pyramid extends Landmark {

    private boolean hasInvested = false;

    public Pyramid(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        if (!hasInvested) {
            this.getOwner().getTechnology().philosophize();
            hasInvested = true;
        }
        super.invest();
    }
}