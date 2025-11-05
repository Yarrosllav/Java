package org.example;

import org.example.animals.Animal;
import org.example.cages.Cage;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private final List<Cage<? extends Animal>> cages = new ArrayList<>();
    public int getCountOfAnimals(){
        int totalAnimals = 0;
        for (Cage<? extends Animal> cage: cages){
            totalAnimals += cage.getCurrentCount();
        }
        return totalAnimals;
    }
    public void addCage(Cage<? extends Animal> cage){
        cages.add(cage);
    }

    public List<Cage<? extends Animal>> getCages(){
        return new ArrayList<>(cages);
    }

}
