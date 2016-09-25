public class Settlement {
    private Building[] buildings;
    private int numBuildings;
    private String name;

    public Settlement(String name) {
        buildings = new Building[1];
        this.name = name;
        numBuildings = 0;
    }

    public String getName() {
        return name;
    }

    public boolean build(int allottedMoney, Population population, int cost,
        int workersRequired) {

        if (allottedMoney >= cost
            && population.getCivilians() >= workersRequired) {
            Building aBuilding = new Building(cost, workersRequired);
            addBuilding(aBuilding);
            return true;
        }
        return false;
    }

    public void addBuilding(Building building) {
        if (numBuildings < buildings.length) {
            buildings[numBuildings] = building;
            numBuildings++;
        } else {
            buildings = expandSettlement(buildings);
            buildings[numBuildings] = building;
            numBuildings++;
        }
    }

    public Building[] expandSettlement(Building[] buildingArray) {
        Building[] tempArray = new Building[buildingArray.length*2];

        for (int i = 0; i < buildingArray.length; i++) {
            tempArray[i] = buildingArray[i];
        }

        return tempArray;
    }
}