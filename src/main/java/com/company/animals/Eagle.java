package com.company.animals;

public class Eagle extends Bird implements Flyable {


    public Eagle(String name, int age, int legs, double height, double weight, String wings) {
        super(name, age, legs, height, weight, wings);
    }

    @Override
    public void fly() {
        System.out.println("Eagle :" + this.getName() + " is fly");
    }

}
