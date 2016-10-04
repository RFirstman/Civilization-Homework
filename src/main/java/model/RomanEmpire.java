package model;

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

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }

}
