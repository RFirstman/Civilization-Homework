public class MeleeUnit extends MilitaryUnit {

    private int health = 100;
    private int baseEndurance = 10;
    private int pay = 10;
    private int initialGoldCost = 14;
    private int initialFoodCost = 5;
    private int initialResourceCost = 0;
    private int damage = 30;

    public MilitaryUnit(Civilization owner) {
        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, damage);
    }

    public char symbol() {
        return 'M';
    }

    public void battle(MapObject mapObject) {
        mapObject.damage(damage);

        if (!mapObject.isDestroyed()
            && (mapObject instanceof MeleeUnit
                || mapObject instanceof HybridUnit)) {
            damage(mapObject.getDamage());
        }
    }

    @Override
    public String toString() {
        return "Melee Unit " + super.toString();
    }
}