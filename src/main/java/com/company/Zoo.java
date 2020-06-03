package com.company;

import com.company.animals.Animal;
import com.company.animals.Bird;
import com.company.cages.Aviary;
import com.company.cages.BirdAviary;
import com.company.exceptions.NoFreePlaceException;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Aviary<? extends Animal>> cages = new ArrayList<>();

    int getCountOfAnimals() {
        int animalsInZoo = 0;
        for (int i = 0; i < cages.size(); i++) {
            animalsInZoo += cages.get(i).getCountOfAnimals();
        }
        return animalsInZoo;
    }

    void addCage(Aviary<? extends Animal> aviary) {
        cages.add(aviary);
    }

    public List<Aviary<? extends Animal>> getCages() {
        return cages;
    }
}
