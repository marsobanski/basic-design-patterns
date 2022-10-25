package co.devfoundry.factory.homework.car.factory;

import co.devfoundry.factory.homework.car.Car;
import co.devfoundry.factory.homework.car.FordModel;
import co.devfoundry.factory.homework.car.VolvoModel;

public interface Factory {
    Car buildFord(FordModel model);
    Car buildVolvo(VolvoModel model);
}
