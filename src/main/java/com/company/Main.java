package com.company;

import com.company.animals.Eagle;
import com.company.animals.Lion;
import com.company.cages.BirdAviary;
import com.company.cages.LionAviary;
import com.company.cages.MammalAviary;
import com.company.exceptions.NoFreePlaceException;
import com.company.exceptions.RemovingAnimalNotFoundException;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws NoFreePlaceException, RemovingAnimalNotFoundException {
        Date date = new Date();
        System.out.println(date);
    }
}
