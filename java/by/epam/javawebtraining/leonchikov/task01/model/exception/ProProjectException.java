package by.epam.javawebtraining.leonchikov.task01.model.exception;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class ProProjectException extends Exception {

    public ProProjectException() {
    }

    public ProProjectException(String message) {
        super(message);
    }

    public ProProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProProjectException(Throwable cause) {
        super(cause);
    }
}
