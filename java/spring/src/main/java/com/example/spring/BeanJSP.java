package com.example.spring;

public class BeanJSP {
    private String name;
    private String color;

    BeanJSP() {
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String introduce() {
        return "My name is " + name + " and I'm " + color;
    }
}