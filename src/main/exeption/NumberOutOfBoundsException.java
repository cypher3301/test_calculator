package main.exeption;

public class NumberOutOfBoundsException extends NumberFormatException{
    public NumberOutOfBoundsException() {
        System.out.println("Not correct value");
    }
}
