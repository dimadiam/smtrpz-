package com.company.cages;

import com.company.animals.Animal;
import com.company.exceptions.NoFreePlaceException;
import com.company.exceptions.RemovingAnimalNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Aviary<T extends Animal> {
    private int size;
    private int countOfAnimals;
    private List<T> animals;

    public Aviary(int size) { //init aviary without animals
        this.size = size;
        this.animals = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCountOfAnimals() {
        return countOfAnimals;
    }

    public void setCountOfAnimals(int countOfAnimals) {
        this.countOfAnimals = countOfAnimals;
    }

    public void addAnimal(T animal) throws NoFreePlaceException {
        if (size == countOfAnimals) {
            throw new NoFreePlaceException((Animal) animal);
        } else {
            this.animals.add(animal);
            countOfAnimals++;
        }

    }

    public void removeAnimal(T animal) throws RemovingAnimalNotFoundException {
        if (!animals.contains(animal)) {
            throw new RemovingAnimalNotFoundException((Animal) animal);
        } else {
            animals.remove(animal);
            countOfAnimals--;
        }
    }

    public String getFreeAndBusyPlaces() {
        return "Free places : " + (size - countOfAnimals) + " , Busy places   : " + countOfAnimals + " , Max places   : " + size;
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "size=" + size +
                ", countOfAnimals=" + countOfAnimals +
                ", animals=" + animals +
                '}';
    }
}
