package model;

import java.util.Random;

class RomanEmpire extends Civilization {

    private Hills hills = new Hills();

    public RomanEmpire() {
        super("Roman Empire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int tempCoal = hills.mineCoal();
        super.produceResources(tempCoal);
        return "You have explored your surroundings and have mined"
            + tempCoal + " coal!";
    }

}
