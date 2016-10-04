package model;

public class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization owner) {
        super(owner);
        setDamage((int) (getDamage() * 1.5));
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public void battle(MapObject obj) {
        obj.damage(getDamage());

        if (!obj.isDestroyed()
            && (obj instanceof MeleeUnit)) {
            damage(((MilitaryUnit) obj).getDamage());
        }
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }

}