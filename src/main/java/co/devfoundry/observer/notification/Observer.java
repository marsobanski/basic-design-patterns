package co.devfoundry.observer.notification;

import co.devfoundry.observer.order.Order;

public interface Observer {
    void update(Order order);

}
