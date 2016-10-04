package model;

public class SettlerUnit extends Unit implements Convertable {

    private String townName;

    public SettlerUnit(Civilization owner, String townName) {
        super(owner);
        this.townName = townName;
    }

    public Building convert() {
        this.getOwner().incrementNumSettlements();
        return this.getOwner().getSettlement(townName);
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public char symbol() {
        return 's';
    }

    @Override
    public String toString() {
        return "Setllers of " + townName + ". " + super.toString();
    }
}