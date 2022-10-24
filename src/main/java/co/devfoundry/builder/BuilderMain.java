package co.devfoundry.builder;

public class BuilderMain {
    public static void main(String[] args) {

        SmallHouseBuilder smallHouseBuilder = new SmallHouseBuilder();
        HouseDirector smallHouseDirector = new HouseDirector(smallHouseBuilder);
        smallHouseDirector.buildHouse();
        House smallHouse = smallHouseBuilder.getHouse();

        BigHouseBuilder bigHouseBuilder = new BigHouseBuilder();
        HouseDirector bigHouseDirector = new HouseDirector(bigHouseBuilder);
        bigHouseDirector.buildHouse();
        House bigHouse = bigHouseDirector.getHouse();


    }
}
