public class QinDynasty {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River("Wei");
    private Technology technology = new Technology();
    private Strategy strategy = new Strategy();
    private Hills hills = new Hills();
    private Settlement[] settlementArray;
    private int numSettlements;

    public QinDynasty() {
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

    public Hills getHills() {
        return hills;
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

    public boolean buildWall(Settlement settlement) {
        if (treasury.spend(1000) && population.canWork(100)) {
            settlement.build(treasury.getCoins(), population, 1000, 100);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildHouse(Settlement settlement) {
        if (treasury.spend(30) && population.canWork(8)) {
            settlement.build(treasury.getCoins(), population, 30, 8);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public void establishLegalism() {
        if (population.getHappiness() >= 20) {
            technology.philosophize();
        }
    }
}