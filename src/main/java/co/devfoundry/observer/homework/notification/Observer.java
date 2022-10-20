package co.devfoundry.observer.homework.notification;

import co.devfoundry.observer.homework.weatherForecast.WeatherForecast;

public interface Observer {

    void update(WeatherForecast weatherForecast);
}
