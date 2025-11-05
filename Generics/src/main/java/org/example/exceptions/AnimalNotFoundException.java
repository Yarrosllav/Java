package org.example.exceptions;

public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(String message){
        super(message);
    }
}
