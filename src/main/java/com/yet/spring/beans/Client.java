package com.yet.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {

    public Client() {
    }

    private String id;
    private String fullName;
    private String greeting;

    public void setGreeting(String gr) {
        this.greeting = gr;
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
