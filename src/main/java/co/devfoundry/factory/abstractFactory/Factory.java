package co.devfoundry.factory.abstractFactory;

abstract public class Factory {

    abstract public InfantryUnit createInfantryUnit(UnitType type);
    abstract public MechanizedUnit createMechanizedUnit(UnitType type);
    abstract public WaterUnit createWaterUnit(UnitType type);
}
