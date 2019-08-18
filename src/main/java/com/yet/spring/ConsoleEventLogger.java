package com.yet.spring;

public class ConsoleEventLogger implements EventLogger{
    public ConsoleEventLogger() {
    }

    public void logEvents(Event event){
        System.out.println(event);
    }
}
