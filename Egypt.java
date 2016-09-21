public class Egypt {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River("Nile");
    private Technology technology = new Technology();
    private Strategy strategy = new Strategy();
    private Desert desert = new Desert();
    private Settlement[] settlementArray;
    private numSettlements;

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
        return Strategy;
    }

    public Desert getDesert() {
        return desert;
    }

    public int getNumSettlements() {
        return numSettlements;
    }

    public boolean settle(Settlement settlement) {
        for (int i = 0; i < settlementArray.length; i++) {
            if (settlementArray[i] == null) {
                settlementArray[i] = settlement;
                numSettlements++;
                return true;
            }
            return false;
        }
    }

    public boolean buildPyramid(Settlement settlement) {
        if (treasury.getCoins() >= 500
            && population.getCivilians() >= 100) {
            settlement.build(strategy.getCoins(), population, 500, 100);
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