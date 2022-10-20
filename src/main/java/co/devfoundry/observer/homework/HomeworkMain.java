package co.devfoundry.observer.homework;

import co.devfoundry.observer.homework.notification.Observer;
import co.devfoundry.observer.homework.notification.Pidgeon;
import co.devfoundry.observer.homework.notification.Telegram;
import co.devfoundry.observer.homework.notification.Telephone;
import co.devfoundry.observer.homework.weatherForecast.WeatherForecast;

public class HomeworkMain {

    public static void main(String[] args) {

        WeatherForecast wprForecast = new WeatherForecast("WPR", 26, 1013);
        WeatherForecast wawaForecast = new WeatherForecast("WAWA", 31, 1011);

        Observer pidgeon = new Pidgeon();
        Observer telegram = new Telegram();
        Observer telephone = new Telephone();

        wprForecast.registerObservers(pidgeon, telegram);
        wawaForecast.registerObservers(telephone, telegram);

        wprForecast.changePressure(1010);
        wprForecast.changeTemperature(11);
        wawaForecast.changePressure(2017);
        wawaForecast.changeTemperature(38);
    }
}
