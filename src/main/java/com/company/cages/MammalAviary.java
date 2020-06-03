package com.company.cages;

import com.company.animals.Mammal;

public class MammalAviary<T extends Mammal> extends Aviary<T> {
    public MammalAviary(int size) {
        super(size);
    }
}
