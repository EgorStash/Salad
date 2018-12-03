package exceptions;

public class InvalidDateException extends Exception {

    public InvalidDateException() {
        System.out.println("You have expired products!");
    }
}
