package model;

public class MeleeUnit extends MilitaryUnit {

    public MeleeUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    public char symbol() {
        return 'M';
    }

    public void battle(MapObject obj) {
        obj.damage(this.getDamage());

        if (!obj.isDestroyed()
            && (obj instanceof MeleeUnit
                || obj instanceof HybridUnit)) {
            damage(((MilitaryUnit) obj).getDamage());
        }
    }

    @Override
    public String toString() {
        return "Melee Unit " + super.toString();
    }
}