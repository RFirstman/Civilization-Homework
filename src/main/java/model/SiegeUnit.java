package model;

public class SiegeUnit extends MilitaryUnit {

    private int health = 200;
    private int baseEndurance = 5;
    private int pay = 10;
    private int initialGoldCost = 14;
    private int initialFoodCost = 5;
    private int initialResourceCost = 10;
    private int damage = 60;

    public SiegeUnit(Civilization owner) {
        super(200, owner, 5, 10, 14, 5, 10, 60);
    }

    @Override
    public char symbol() {
        return 'S';
    }

    @Override
    public void battle(MapObject obj) {
        if (obj instanceof Building) {
            obj.damage(this.getDamage());
        }
    }

    @Override
    public void attack(MapObject obj) {
        this.getOwner().getStrategy().siege();
        battle(obj);
        this.setCanAttack(false);
    }
}