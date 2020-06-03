package com.company.exceptions;

import com.company.animals.Animal;

public class NoFreePlaceException extends Exception {
    public NoFreePlaceException(Animal animal){
            super("No free places for the  : " + animal.getName());
    }
}
