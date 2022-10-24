package co.devfoundry.builder;

public class HouseDirector {

    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void buildHouse() {
        houseBuilder.buildDoors();
        houseBuilder.buildFloors();
        houseBuilder.buildGarage();
        houseBuilder.buildRoof();
        houseBuilder.buildRooms();
        houseBuilder.buildWindows();
        houseBuilder.buildWalls();
    }

    public House getHouse() {
        return this.houseBuilder.getHouse();
    }
}
