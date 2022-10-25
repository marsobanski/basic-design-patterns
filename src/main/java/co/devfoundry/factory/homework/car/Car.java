package co.devfoundry.factory.homework.car;

import co.devfoundry.factory.homework.FuelType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
abstract public class Car {

    private int speed;
    private FuelType fuel;
    private int year;
    private SteeringWheelPosition steeringWheelPosition;
}
