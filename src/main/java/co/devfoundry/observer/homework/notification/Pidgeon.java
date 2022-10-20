package co.devfoundry.observer.homework.notification;

import co.devfoundry.observer.homework.weatherForecast.WeatherForecast;

public class Pidgeon implements Observer {

    @Override
    public void update(WeatherForecast weatherForecast) {
        System.out.println("Pidgeon shouts: Weather updated. Now the weather is " + weatherForecast.toString());
    }
}
