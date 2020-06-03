package com.company.cages;

import com.company.animals.Bird;

public class BirdAviary<T extends Bird> extends Aviary<T> {
    public BirdAviary(int size) {
        super(size);
    }

}
