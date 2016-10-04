public class SiegeUnit extends MilitaryUnit {

    private int health = 200;
    private int baseEndurance = 5;
    private int pay = 10;
    private int initialGoldCost = 14;
    private int initialFoodCost = 5;
    private int initialResourceCost = 10;
    private int damage = 60;

    public SiegeUnit(Civilization owner) {
        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, damage);
    }

    @Override
    public char symbol() {
        return 'S';
    }

    @Override
    public void battle(MapObject mapObject) {
        if (mapObject instanceof Building) {
            mapObject.damage(damage);
        }
    }

    @Override
    public void attack(MapObject mapObject) {
        owner.getStrategy().siege();
        battle();
        canAttack = false;
    }