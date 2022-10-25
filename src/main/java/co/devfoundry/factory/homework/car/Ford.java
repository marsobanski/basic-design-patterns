package co.devfoundry.factory.homework.car;

import lombok.Data;

@Data
public class Ford extends Car {

    public Ford(int speed, FuelType fuel, int year, SteeringWheelPosition steeringWheelPosition) {
        super(speed, fuel, year, steeringWheelPosition);
    }
}
