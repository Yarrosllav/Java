package org.example.exceptions;

public class CageFullException extends RuntimeException{
    public CageFullException(String message){
        super(message);
    }
}
