package com.nixsolutions.service.impl;

public class Role {
    public Role(String name) {
        this.name = name;
    }

    long id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
