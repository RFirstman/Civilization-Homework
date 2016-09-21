public class Settlement {
    private Building[] buildings = new Building[1];
    private int numBuildings;
    private String settlement;

    public Settlement(String settlement) {
        this.settlement = settlement;
        numBuildings = 0;
    }

    public boolean build(int allottedMoney, Population population, int cost,
        int workersRequired) {

        if (cost < allottedMoney
            && workersRequired < population.getCivilians()) {
            Building aBuilding = new Building(cost, workersRequired);
            addBuilding(aBuilding);
        }
    }

    public void addBuilding(Building building) {
        if (numBuildings < buildings.length) {
            buildings[numBuildings] = building;
            numBuildings++;
        } else {
            buildings = incrementArray(buildings);
            buildings[numBuildings] = building;
            numBuildings++;
        }
    }

    public Building[] expandSettlement(Building[] buildingArray) {
        private Building[] tempArray = new Building[buildingArray.length*2];

        for (int i = 0; i < buildingArray.length; i++) {
            tempArray[i] = buildingArray[i];
        }

        return tempArray;
    }
}