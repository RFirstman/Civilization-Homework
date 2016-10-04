package model;

public class RangedUnit extends MilitaryUnit {

    public RangedUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    public char symbol() {
        return 'R';
    }

    public void battle(MapObject obj) {
        obj.damage(this.getDamage());

        if (!obj.isDestroyed()
            && (obj instanceof RangedUnit
                || obj instanceof HybridUnit)) {
            damage(((MilitaryUnit) obj).getDamage());
        }
    }

    @Override
    public String toString() {
        return "Ranged Unit. " + super.toString();
    }
}