package exercise;

import exercise.exception.CustomException;

// BEGIN
public class NegativeRadiusException extends Exception {

    public NegativeRadiusException() {
        super("Радиус круга не может быть отрицательным");
    }

    public NegativeRadiusException(String message) {
        super(message);
    }
}
// END
