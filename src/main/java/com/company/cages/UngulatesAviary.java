package com.company.cages;

import com.company.animals.Ungulates;

public class UngulatesAviary<T extends Ungulates> extends MammalAviary<T> {
    public UngulatesAviary(int size) {
        super(size);
    }
}
