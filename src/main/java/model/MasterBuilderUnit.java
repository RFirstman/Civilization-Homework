package model;

public class MasterBuilderUnit extends Unit implements Convertable {

    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getLandmark();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public char symbol() {
        return 'm';
    }

    @Override
    public String toString() {
        return "Master Builders. " + super.toString();
    }
}