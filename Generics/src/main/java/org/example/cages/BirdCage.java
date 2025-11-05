package org.example.cages;

import org.example.animals.Bird;

public class BirdCage<T extends Bird> extends Cage<T> {
    public BirdCage(int maxCapacity) {
        super(maxCapacity);
    }
}
