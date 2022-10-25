package co.devfoundry.factory.abstractFactory;

public class BlueFactory extends Factory{

    @Override
    public InfantryUnit createInfantryUnit(UnitType type) {
        if (type.equals(UnitType.RILFEMAN)) {
            return new Rifleman(80, 0, 40);
        } else if (type.equals(UnitType.SNIPER)) {
            return new Sniper(200, 0, 60);
        } else {
            throw new UnsupportedOperationException("Wrong infantry Type: " + type);
        }
    }

    @Override
    public MechanizedUnit createMechanizedUnit(UnitType type) {
        if (type.equals(UnitType.TANK)) {
            return new Tank(400, 0, 400);
        } else if (type.equals(UnitType.JEEP)) {
            return new Jeep(300, 0, 80);
        } else {
            throw new UnsupportedOperationException("Wrong infantry Type: " + type);
        }
    }

    @Override
    public WaterUnit createWaterUnit(UnitType type) {
        if (type.equals(UnitType.CARRIER)) {
            return new Carrier(1800, 0, 700);
        } else if (type.equals(UnitType.BATTLESHIP)) {
            return new Battleship(6000, 0, 800);
        } else {
            throw new UnsupportedOperationException("Wrong infantry Type: " + type);
        }
    }
}
