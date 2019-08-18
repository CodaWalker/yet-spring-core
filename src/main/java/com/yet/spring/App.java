package com.yet.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public App() {
    }

    public App(Client client,EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private Client client;
    private EventLogger eventLogger;
    public void logEvent(Event msg){
        //Event message = msg.replaceAll(client.getId(),client.getFullName());
        //eventLogger.logEvents(message);
    }
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        App app = (App) applicationContext.getBean("app");

        //app.logEvent("Some event for user 1");
        //app.logEvent("Some event for user 2");
    }

}
