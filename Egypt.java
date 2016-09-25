public class Egypt {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River("Nile");
    private Technology technology = new Technology();
    private Strategy strategy = new Strategy();
    private Desert desert = new Desert();
    private Settlement[] settlementArray;
    private int numSettlements;

    public Egypt() {
        settlementArray = new Settlement[10];
        numSettlements = 0;
    }

    public Population getPopulation() {
        return population;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public River getRiver() {
        return river;
    }

    public Technology getTechnology() {
        return technology;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Desert getDesert() {
        return desert;
    }

    public int getNumSettlements() {
        return numSettlements;
    }

    public Settlement[] getSettlements() {
        return settlementArray;
    }

    public boolean settle(Settlement settlement) {
        for (int i = 0; i < settlementArray.length; i++) {
            if (settlementArray[i] == null) {
                settlementArray[i] = settlement;
                numSettlements++;
                return true;
            }
        }
        return false;
    }

    public boolean buildPyramid(Settlement settlement) {
        if (treasury.spend(500) && population.canWork(100)) {
            settlement.build(treasury.getCoins(), population, 500, 100);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void practiceHieroglyphics() {
        technology.improveWriting();
        population.increaseHappiness(10);
    }
}