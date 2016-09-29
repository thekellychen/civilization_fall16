public class Settlement {
    private Building[] buildings;
    private String name;
    private int numBuildings;

    public Settlement(String name) {
        this.name = name;
        this.buildings = new Building[10];
        this.numBuildings = 0;
    }

    public void addBuilding(Building building) {
        numBuildings++;
        if (numBuildings > buildings.length) {
            expandSettlement();
        }
        buildings[numBuildings - 1] = building;
    }

    public boolean build(int allottedMoney, Population population,
        int cost, int workersRequired) {
        if ((cost <= allottedMoney) && population.canWork(workersRequired)) {
            Building building = new Building(cost, workersRequired);
            addBuilding(building);
            return true;
        }
        return false;
    }

    public void expandSettlement() {
        Building[] tempArray =  new Building[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            tempArray[i] = buildings[i];
        }
        buildings = tempArray;
    }

    public String getName() {
        return this.name;
    }
}