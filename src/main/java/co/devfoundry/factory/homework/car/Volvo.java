package co.devfoundry.factory.homework.car;

import lombok.Data;

@Data
public class Volvo extends Car {

    public Volvo(int speed, FuelType fuel, int year, SteeringWheelPosition steeringWheelPosition) {
        super(speed, fuel, year, steeringWheelPosition);
    }
}
