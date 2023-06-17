package by.sterlikov.helloservletrun;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener

public class MySecondListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Context attribute added");
        System.out.println("Event: " + event.getName() + " " + event.getValue());
        //ServletContextAttributeListener.super.attributeAdded(event);
    }
}
