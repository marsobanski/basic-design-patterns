package co.devfoundry.observer.order;

import co.devfoundry.observer.notification.Observer;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Order implements Observable {

    Set<Observer> registeredObservers = new HashSet<>();
    private Long orderNumber;
    private OrderStatus orderStatus;

    public Order(Long orderNumber, OrderStatus orderStatus) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
    }

    public void registerObserver(Observer observer) {
        registeredObservers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        registeredObservers.remove(observer);
    }

    public void notifyObservers() {
        registeredObservers.forEach(observer -> observer.update(this));
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        setOrderStatus(orderStatus);
        notifyObservers();
    }
}
