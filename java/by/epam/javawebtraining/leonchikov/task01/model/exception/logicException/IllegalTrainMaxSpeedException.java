package by.epam.javawebtraining.leonchikov.task01.model.exception.logicException;

import by.epam.javawebtraining.leonchikov.task01.model.exception.LogicalException;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class IllegalTrainMaxSpeedException extends LogicalException {

    public IllegalTrainMaxSpeedException() {
    }

    public IllegalTrainMaxSpeedException(String message) {
        super(message);
    }
}
