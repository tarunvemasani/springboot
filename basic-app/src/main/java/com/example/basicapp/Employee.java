package com.example.basicapp;

public class Employee {
    int id;
    String name;
    Employee(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
