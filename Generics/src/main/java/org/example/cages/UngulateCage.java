package org.example.cages;

import org.example.animals.Ungulate;

public class UngulateCage<T extends Ungulate> extends MammalCage<T> {
    public UngulateCage(int maxCapacity) {
        super(maxCapacity);
    }
}
