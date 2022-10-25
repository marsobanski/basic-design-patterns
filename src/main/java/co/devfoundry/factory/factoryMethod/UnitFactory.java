package co.devfoundry.factory.factoryMethod;

public class UnitFactory extends Factory {

    @Override
    public Unit createUnit(UnitType unitType) {
        if (unitType.equals(UnitType.RILFEMAN)) {
            return new Rifleman(100, 0, 20);
        } else if (unitType.equals(UnitType.TANK)) {
            return new Tank(1000, 0, 400);
        } else {
            throw new UnsupportedOperationException("No Such Type");
        }
    }
}
