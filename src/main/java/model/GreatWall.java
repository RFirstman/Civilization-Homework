package model;

public class GreatWall extends Landmark {

    private boolean hasInvested = false;

    public GreatWall(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        if (!hasInvested) {
            this.getOwner().getStrategy().battle();
            hasInvested = true;
        }
        super.invest();
    }
}