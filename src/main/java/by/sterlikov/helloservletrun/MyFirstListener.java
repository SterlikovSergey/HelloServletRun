package by.sterlikov.helloservletrun;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
@WebListener

public class MyFirstListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Attribute added");
        System.out.println("Event: " + event.getName() +  " " +  event.getValue());
        //HttpSessionAttributeListener.super.attributeAdded(event);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute replaced");
        System.out.println("Event: " + event.getName() +  " " +  event.getValue());
        //HttpSessionAttributeListener.super.attributeReplaced(event);
    }
}
