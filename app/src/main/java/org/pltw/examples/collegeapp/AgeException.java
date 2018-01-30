package org.pltw.examples.collegeapp;

public class AgeException extends RuntimeException {
    public AgeException(String message){
        super(message);
    }

    public String joinMessageAndYear(String message, int year){
        return message + " " + String.valueOf(year);
    }
}
