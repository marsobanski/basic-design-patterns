package co.devfoundry.observer.homework.notification;

import co.devfoundry.observer.homework.weatherForecast.WeatherForecast;

public class Telephone implements Observer {

    @Override
    public void update(WeatherForecast weatherForecast) {
        System.out.println("Telephone rings: Weather updated. Now the weather is " + weatherForecast.toString());
    }
}
