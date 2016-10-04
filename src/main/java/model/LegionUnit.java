public class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization owner) {
        super(owner);
        setDamage((int)(getDamage() * 1.5));
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public void battle(MapObject mapObject) {
        mapObject.damage(damage);

        if (!mapObject.isDestroyed()
            && (mapObject instanceof MeleeUnit)) {
            damage(mapObject.getDamage());
        }
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }

}