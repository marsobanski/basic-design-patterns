package co.devfoundry.factory.homework;

import co.devfoundry.factory.homework.car.Car;
import co.devfoundry.factory.homework.car.FordModel;
import co.devfoundry.factory.homework.car.VolvoModel;
import co.devfoundry.factory.homework.factory.CommonWealthFactory;
import co.devfoundry.factory.homework.factory.ContinentalFactory;
import co.devfoundry.factory.homework.factory.Factory;

public class FactoryHomeworkMain {

    public static void main(String[] args) {

        Factory commonwealthFactory = new CommonWealthFactory();
        Factory continentalFactory = new ContinentalFactory();

        Car bmw = commonwealthFactory.buildVolvo(VolvoModel.XC60);
        System.out.println(bmw.getSteeringWheelPosition());

        Car ford = continentalFactory.buildFord(FordModel.FOCUS);
        System.out.println(ford.getSteeringWheelPosition());
    }
}
