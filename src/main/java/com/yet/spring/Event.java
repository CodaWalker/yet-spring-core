package com.yet.spring;

import java.util.Date;

public class Event {
    private int id;
    private String msg;
    private Date date;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
