package model;

public abstract class MilitaryUnit extends MapObject {
    private int damage, baseEndurance, initialGoldCost, initialHappinessCost;
    private int pay, initialFoodCost, initialResourceCost;
    private boolean canAttack;

    public MilitaryUnit(int health, Civilization owner, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {

        super(health, owner);
        this.baseEndurance = baseEndurance;
        this.pay = pay;
        this.initialGoldCost = initialGoldCost;
        this.initialFoodCost = initialFoodCost;
        this.initialResourceCost = initialResourceCost;
        this.damage = damage;
        initialHappinessCost = 10;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBaseEndurance() {
        return baseEndurance;
    }

    public void setBaseEndurance() {
        this.baseEndurance = baseEndurance;
    }

    public int getPay() {
        return pay;
    }

    public int getInitialGoldCost() {
        return initialGoldCost;
    }

    public int getInitialFoodCost() {
        return initialFoodCost;
    }

    public int getInitialResourceCost() {
        return initialResourceCost;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    @Override
    public void tick() {
        canAttack = true;
    }

    public abstract void battle(MapObject mapObject);

    public void attack(MapObject mapObject) {
        owner.getStrategy().battle();
        battle(mapObject);
        canAttack = false;
    }

    @Override
    public String toString() {
        return "Military Unit " + super.toString();
    }
}