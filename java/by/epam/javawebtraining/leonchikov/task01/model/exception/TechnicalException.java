package by.epam.javawebtraining.leonchikov.task01.model.exception;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TechnicalException extends ProProjectException {

    public TechnicalException() {
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }
}
