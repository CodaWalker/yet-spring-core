package com.yet.spring.beans;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event() {
    }

    public Event(int id, Date date, DateFormat dateFormat) {
        this.id = id;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public int setId() {
        Random random = new Random();
       return random.nextInt();
    }

    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                "}\n";
    }
}
