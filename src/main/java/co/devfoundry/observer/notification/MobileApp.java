package co.devfoundry.observer.notification;

import co.devfoundry.observer.order.Order;

public class MobileApp implements Observer{

    public void update(Order order) {
        System.out.println("MobileApp: Order " + order.getOrderNumber() + " changed status to " + order.getOrderStatus());
    }
}
