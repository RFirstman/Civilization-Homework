package model;

public abstract class MilitaryUnit extends Unit {
    private int damage;

    public MilitaryUnit(int health, Civilization owner, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {

        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        this.damage = damage;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void tick() {
        super.tick();
        setCanAttack(true);
    }

    public abstract void battle(MapObject mapObject);

    public void attack(MapObject mapObject) {
        this.getOwner().getStrategy().battle();
        this.battle(mapObject);
        setCanAttack(false);
    }

    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }
}