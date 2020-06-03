package com.company.animals;

import java.util.Objects;

public class Animal {
    private String name;
    private int age;
    private int legs;
    private double height;
    private double weight;



    public Animal(String name, int age, int legs, double height, double weight) {
        this.name = name;
        this.age = age;
        this.legs = legs;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getAge() == animal.getAge() &&
                getLegs() == animal.getLegs() &&
                Double.compare(animal.getHeight(), getHeight()) == 0 &&
                Double.compare(animal.getWeight(), getWeight()) == 0 &&
                getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getLegs(), getHeight(), getWeight());
    }
}
