public class Strategy {
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;
    private int strategyLevel;
    private boolean conqueredTheWorld;

    public Strategy() {
        strategyLevel = 0;
        conqueredTheWorld = false;
    }

    public int getStrategyLevel() {
        return strategyLevel;
    }

    public void battle() {
        strategyLevel += BATTLE_INCREASE;
        checkCondition();

    }

    public void siege() {
        strategyLevel += SIEGE_INCREASE;
        checkCondition();
    }

    private void checkCondition() {
        if (strategyLevel > 180) {
            conqueredTheWorld = true;
        }
    }

    public boolean conqueredTheWorld() {
        return conqueredTheWorld;
    }

}