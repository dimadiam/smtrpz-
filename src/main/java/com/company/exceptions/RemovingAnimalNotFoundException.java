package com.company.exceptions;

import com.company.animals.Animal;

public class RemovingAnimalNotFoundException extends Exception{
    public RemovingAnimalNotFoundException(Animal animal){
        super(animal.getName() + " not found in the cage ");
    }
}
