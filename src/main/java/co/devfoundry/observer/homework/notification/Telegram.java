package co.devfoundry.observer.homework.notification;

import co.devfoundry.observer.homework.weatherForecast.WeatherForecast;

public class Telegram implements Observer {

    @Override
    public void update(WeatherForecast weatherForecast) {
        System.out.println("Written in telegram: Weather updated. Now the weather is " + weatherForecast.toString());
    }
}
