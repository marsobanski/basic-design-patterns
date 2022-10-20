package co.devfoundry.observer.homework.weatherForecast;

import co.devfoundry.observer.homework.notification.Observer;
import lombok.Data;

import java.util.*;

@Data
public class WeatherForecast implements Observable {

    private String name;
    private int temperature;
    private int pressure;
    private Set<Observer> registeredObservers = new HashSet<>();

    public WeatherForecast(String name, int temperature, int pressure) {
        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    @Override
    public void registerObservers(Observer... observers) {
        registeredObservers.addAll(Arrays.asList(observers));
    }

    @Override
    public void unregisterObservers(Observer... observers) {
        registeredObservers.removeAll(Arrays.asList(observers));
    }

    @Override
    public void registerObservers(Collection<Observer> observers) {
        registeredObservers.addAll(observers);
    }

    @Override
    public void unregisterObservers(Collection<Observer> observers) {
        registeredObservers.removeAll(observers);
    }

    @Override
    public void notifyObservers() {
        registeredObservers.forEach(observer -> observer.update(this));
    }

    public void changeTemperature(int temperature) {
        this.setTemperature(temperature);
        notifyObservers();
        System.out.println("--------------------------------");
    }

    public void changePressure(int pressure) {
        this.setPressure(pressure);
        notifyObservers();
        System.out.println("--------------------------------");
    }
}
