package co.devfoundry.observer.notification;

import co.devfoundry.observer.order.Order;

public class Email implements Observer{

    public void update(Order order) {
        System.out.println("Email: Order " + order.getOrderNumber() + " changed status to " + order.getOrderStatus());
    }
}
