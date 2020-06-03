package com.company.cages;

import com.company.animals.Lion;

public class LionAviary<T extends Lion> extends MammalAviary<T> {
    public LionAviary(int size) {
        super(size);
    }
}
