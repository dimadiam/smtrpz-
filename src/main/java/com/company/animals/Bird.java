package com.company.animals;

public class Bird extends Animal {
    private String wings;

    public Bird(String name, int age, int legs, double height, double weight,String wings) {
        super(name, age, legs, height, weight);
        this.wings = wings;
    }


    public String getWings() {
        return wings;
    }

    public void setWings(String wings) {
        this.wings = wings;
    }



}
