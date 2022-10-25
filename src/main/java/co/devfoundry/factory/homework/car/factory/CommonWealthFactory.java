package co.devfoundry.factory.homework.car.factory;

import co.devfoundry.factory.homework.FuelType;
import co.devfoundry.factory.homework.car.*;

public class CommonWealthFactory implements Factory {

    @Override
    public Car buildFord(FordModel model) {
        if (model.equals(FordModel.FOCUS)) {
            return new Ford(100, FuelType.DIESEL, 2002, SteeringWheelPosition.RIGHT);
        } else if (model.equals(FordModel.MONDEO)) {
            return new Ford(120, FuelType.PETROL, 2005, SteeringWheelPosition.RIGHT);
        } else {
            throw new UnsupportedOperationException("No Ford model: " + model);
        }
    }

    @Override
    public Car buildVolvo(VolvoModel model) {
        if (model.equals(VolvoModel.S90)) {
            return new Volvo(150, FuelType.DIESEL, 2010, SteeringWheelPosition.RIGHT);
        } else if (model.equals(VolvoModel.XC60)) {
            return new Volvo(160, FuelType.PETROL, 2012, SteeringWheelPosition.RIGHT);
        } else {
            throw new UnsupportedOperationException("No Ford model: " + model);
        }
    }
}
