package by.epam.javawebtraining.leonchikov.task01.model.exception.logicException;

import by.epam.javawebtraining.leonchikov.task01.model.exception.LogicalException;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class IllegalTrainTypeException extends LogicalException {

    public IllegalTrainTypeException() {
    }

    public IllegalTrainTypeException(String message) {
        super(message);
    }
}
