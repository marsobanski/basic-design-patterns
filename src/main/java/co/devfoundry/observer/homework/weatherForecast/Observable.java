package co.devfoundry.observer.homework.weatherForecast;

import co.devfoundry.observer.homework.notification.Observer;

import java.util.Collection;
import java.util.List;

public interface Observable {

    void registerObservers(Observer... observers);
    void unregisterObservers(Observer... observers);
    void registerObservers(Collection<Observer> observers);
    void unregisterObservers(Collection<Observer> observers);
    void notifyObservers();
}
