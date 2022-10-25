package co.devfoundry.factory;

import co.devfoundry.factory.unit.Factory;
import co.devfoundry.factory.unit.UnitFactory;
import co.devfoundry.factory.unit.UnitType;

public class FactoryMain {

    public static void main(String[] args) {
        Factory factory = new UnitFactory();
        factory.createUnit(UnitType.RILFEMAN);
    }
}
