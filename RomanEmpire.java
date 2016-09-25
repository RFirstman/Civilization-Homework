public class RomanEmpire {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River("Tiber");
    private Technology technology = new Technology();
    private Strategy strategy = new Strategy();
    private Hills hills = new Hills();
    private Settlement[] settlementArray;
    private int numSettlements;

    public RomanEmpire() {
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

    public boolean buildAqueduct(Settlement settlement) {
        if (treasury.spend(250) && population.canWork(130)) {
            settlement.build(treasury.getCoins(), population, 250, 130);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildBathHouse(Settlement settlement) {
        if (treasury.spend(110) && population.canWork(20)) {
            settlement.build(treasury.getCoins(), population, 110, 20);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildVilla(Settlement settlement) {
        if (treasury.spend(80) && population.canWork(15)) {
            settlement.build(treasury.getCoins(), population, 80, 15);
            technology.increaseExperience(5);
            return true;
        }
        return false;
    }

    public void studyPhilosophy() {
        if (population.getHappiness() >= 10) {
            technology.philosophize();
            population.decreaseHappiness(10);
        }
    }
}