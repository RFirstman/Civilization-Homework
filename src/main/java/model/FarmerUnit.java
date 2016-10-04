package model;

public class FarmerUnit extends Unit implements Convertable {

    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getFarm();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public char symbol() {
        return 'f';
    }

    @Override
    public String toString() {
        return "Farmers. " + super.toString();
    }
}