package model;

public class Pyramid extends Landmark {

    public Pyramid(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        this.getOwner().getTechnology().philosophize();
        super.invest();
    }
}