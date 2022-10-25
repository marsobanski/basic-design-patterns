package co.devfoundry.factory.homework.cars;

import co.devfoundry.factory.homework.FuelType;
import lombok.Data;

@Data
public class Volvo extends Car {

    protected Volvo(int speed, FuelType fuel, int year) {
        super(speed, fuel, year);
    }
}
