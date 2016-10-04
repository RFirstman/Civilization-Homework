package model;

import java.util.Random;

class Egypt extends Civilization {

    private Desert desert = new Desert();

    public Egypt() {
        super("Egypt");
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int treasure = desert.findTreasure();
        super.getTreasury().earn(treasure);
        return "You have explored your Desert and found"
            + treasure + " gold!";
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }
}
