package co.devfoundry.factory.abstractFactory;

public class RedFactory extends Factory{

    @Override
    public InfantryUnit createInfantryUnit(UnitType type) {
        if (type.equals(UnitType.RILFEMAN)) {
            return new Rifleman(100, 0, 20);
        } else if (type.equals(UnitType.SNIPER)) {
            return new Sniper(150, 0, 80);
        } else {
            throw new UnsupportedOperationException("Wrong infantry Type: " + type);
        }
    }

    @Override
    public MechanizedUnit createMechanizedUnit(UnitType type) {
        if (type.equals(UnitType.TANK)) {
            return new Tank(500, 0, 300);
        } else if (type.equals(UnitType.JEEP)) {
            return new Jeep(350, 0, 100);
        } else {
            throw new UnsupportedOperationException("Wrong infantry Type: " + type);
        }
    }

    @Override
    public WaterUnit createWaterUnit(UnitType type) {
        if (type.equals(UnitType.CARRIER)) {
            return new Carrier(2000, 0, 500);
        } else if (type.equals(UnitType.BATTLESHIP)) {
            return new Battleship(5000, 0, 1000);
        } else {
            throw new UnsupportedOperationException("Wrong infantry Type: " + type);
        }
    }
}
