package co.devfoundry.observer;

import co.devfoundry.observer.notification.Email;
import co.devfoundry.observer.notification.MobileApp;
import co.devfoundry.observer.notification.TextMessage;
import co.devfoundry.observer.order.Order;
import co.devfoundry.observer.order.OrderStatus;

public class ObserverMain {

    public static void main(String[] args) {

        Order order = new Order(110L, OrderStatus.REGISTERED);

        TextMessage textMessage = new TextMessage();
        Email email = new Email();
        MobileApp mobileApp = new MobileApp();

        order.registerObserver(textMessage);
        order.registerObserver(email);
        order.registerObserver(mobileApp);

        order.notifyObservers();
        System.out.println("----------------------------");

        order.changeOrderStatus(OrderStatus.SENT);

        System.out.println("----------------------------");

        order.unregisterObserver(email);

        order.changeOrderStatus(OrderStatus.RECEIVED);


    }
}
