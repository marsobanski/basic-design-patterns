package co.devfoundry.observer.notification;

import co.devfoundry.observer.order.Order;

public class TextMessage implements Observer{

    public void update(Order order) {
        System.out.println("SMS: Order " + order.getOrderNumber() + " changed status to " + order.getOrderStatus());
    }
}
