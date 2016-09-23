public class RomanEmpire {
    private Population population = new Population();
    private Treasury treasury = new Treasury();
    private CoalMine coalMine = new CoalMine();
    private River river = new River("Tiber");
    private Technology technology = new Technology();
    private Strategy strategy = new Strategy();
    private Hills hills = new Hills();
    private Settlement[] settlementArray;
    private numSettlements;

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
        return Strategy;
    }

    public Desert getHills() {
        return hills;
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

    public boolean buildAqueduct(Settlement settlement) {
        if (treasury.getcoins() >= 250
            && population.getCivilians() >= 130) {
            settlement.build(treasury.getCoins(), population, 250, 130);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildBathHouse(Settlement settlement) {
        if (treasury.getcoins() >= 110
            && population.getCivilians() >= 20) {
            settlement.build(treasury.getCoins(), population, 110, 20);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildVilla(Settlement settlement) {
        if (treasury.getcoins() >= 80
            && population.getCivilians() >= 15) {
            settlement.build(treasury.getCoins(), population, 80, 15);
            technology.increaseExperience(5);
            return true;
        }
        return false;
    }

    public void studyPhilosophy() {
        if (population.getHappiness() >= 10) {
            technology.philosophize();
            population.decreaseHappines(10);
        }
    }
}