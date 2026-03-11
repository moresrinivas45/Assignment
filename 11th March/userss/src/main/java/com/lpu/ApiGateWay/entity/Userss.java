package com.lpu.ApiGateWay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Userss {
	
    @Id
    private int id;
    private String name;
    private String email;

    public Userss() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}