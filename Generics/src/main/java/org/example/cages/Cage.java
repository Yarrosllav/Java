package org.example.cages;

import org.example.animals.*;
import org.example.exceptions.AnimalNotFoundException;
import org.example.exceptions.CageFullException;

import java.util.ArrayList;
import java.util.List;

public abstract class Cage<T extends Animal> {
    private final int maxCapacity;
    private final List<T> animals;


    public Cage(int maxCapacity){
        if(maxCapacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.animals = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public void addAnimal(T animal){
        if(animals.size() >= maxCapacity) throw new CageFullException("The cage is full");
        if(animal != null) {
            animals.add(animal);
        }
    }

    public void removeAnimal(T animal){
        boolean removed = animals.remove(animal);
        if (!removed) {
            throw new AnimalNotFoundException("Animal not found in this cage: " + animal);
        }
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public int getCurrentCount(){
        return animals.size();
    }

    public List<T> getAnimals(){
        return new ArrayList<>(animals);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " capacity=" + getMaxCapacity() +
                ", animals=" + getCurrentCount() +
                '}';
    }
}