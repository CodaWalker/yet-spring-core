package com.yet.spring;

import com.yet.spring.beans.Client;
import com.yet.spring.beans.Event;
import com.yet.spring.beans.EventType;
import com.yet.spring.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static com.yet.spring.beans.EventType.ERROR;
import static com.yet.spring.beans.EventType.INFO;

public class App {

    private Client client;
    private Map<EventType,EventLogger> loggers;
    private EventLogger defaultLogger;

    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }
//    private void logEvent(Event event, String msg, String fileName) {
//        String message = msg.replaceAll(client.getId(), client.getFullName());
//        event.setMsg(message);
//        eventLogger.logEvent(event);
//
//    }
    public void logEvents(ConfigurableApplicationContext configurableApplicationContext){
        Event event = configurableApplicationContext.getBean(Event.class);
        logEvent(INFO,event,"Some event for 1");

        event = configurableApplicationContext.getBean(Event.class);
        logEvent(INFO,event,"Some event for 1");

        event = configurableApplicationContext.getBean(Event.class);
        logEvent(INFO,event,"Some event for 1");

        event = configurableApplicationContext.getBean(Event.class);
        logEvent(ERROR,event,"Some event for 2");

        event = configurableApplicationContext.getBean(Event.class);
        logEvent(null,event,"Some event for 3");
    }

    public static void main(String[] args){

        @SuppressWarnings("resource") // We will remove this suppress in further lessons
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("others.xml");
        ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) configurableApplicationContext.getBean("app");


//        app.logEvent(INFO, event, "Some event for 1");
//        app.logEvent(null, event, "Some event for 2");
//        app.logEvent(null, event, "Some event for 3");
        app.logEvents(configurableApplicationContext);

        configurableApplicationContext.close();
        }

    }


