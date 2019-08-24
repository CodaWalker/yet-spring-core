package com.yet.spring;

import com.yet.spring.beans.Client;
import com.yet.spring.beans.Event;
import com.yet.spring.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;


    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

//    private void logEvent(Event event, String msg, String fileName) {
//        String message = msg.replaceAll(client.getId(), client.getFullName());
//        event.setMsg(message);
//        eventLogger.logEvent(event);
//
//    }

    public static void main(String[] args){

        @SuppressWarnings("resource") // We will remove this suppress in further lessons
       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("context.xml");
        App app = (App) configurableApplicationContext.getBean("app");
        Event event = configurableApplicationContext.getBean(Event.class);
        app.logEvent(event, "Some event for 1");
        event = configurableApplicationContext.getBean(Event.class);
        app.logEvent(event, "Some event for 2");

        configurableApplicationContext.close();
        }

    }


