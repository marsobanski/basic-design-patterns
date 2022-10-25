package co.devfoundry.factory.homework.factory;

import co.devfoundry.factory.homework.car.FuelType;
import co.devfoundry.factory.homework.car.*;

public class ContinentalFactory implements Factory {

    private SteeringWheelPosition position = SteeringWheelPosition.LEFT;

    @Override
    public Car buildFord(FordModel model) {
        if (model.equals(FordModel.FOCUS)) {
            return new Ford(100, FuelType.DIESEL, 2002, position);
        } else if (model.equals(FordModel.MONDEO)) {
            return new Ford(120, FuelType.PETROL, 2005, position);
        } else {
            throw new UnsupportedOperationException("No Ford model: " + model);
        }
    }

    @Override
    public Car buildVolvo(VolvoModel model) {
        if (model.equals(VolvoModel.S90)) {
            return new Volvo(150, FuelType.DIESEL, 2010, position);
        } else if (model.equals(VolvoModel.XC60)) {
            return new Volvo(160, FuelType.PETROL, 2012, position);
        } else {
            throw new UnsupportedOperationException("No Ford model: " + model);
        }
    }
}
