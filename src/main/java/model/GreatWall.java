package model;

public class GreatWall extends Landmark {

    public GreatWall(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        this.getOwner().getStrategy().battle();
        super.invest();
    }
}