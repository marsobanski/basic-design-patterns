package co.devfoundry.observer.order;

import co.devfoundry.observer.notification.Observer;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}
