package co.devfoundry.factory;

import co.devfoundry.factory.abstractFactory.BlueFactory;
import co.devfoundry.factory.abstractFactory.RedFactory;
import co.devfoundry.factory.abstractFactory.UnitType;

public class FactoryMain {

    public static void main(String[] args) {
        BlueFactory blueFactory = new BlueFactory();
        RedFactory redFactory = new RedFactory();

        redFactory.createInfantryUnit(UnitType.SNIPER);
        blueFactory.createMechanizedUnit(UnitType.JEEP);
        redFactory.createWaterUnit(UnitType.CARRIER);

    }
}
