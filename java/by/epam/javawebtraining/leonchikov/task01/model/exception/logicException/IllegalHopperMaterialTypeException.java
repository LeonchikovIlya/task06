package by.epam.javawebtraining.leonchikov.task01.model.exception.logicException;

import by.epam.javawebtraining.leonchikov.task01.model.exception.LogicalException;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class IllegalHopperMaterialTypeException extends LogicalException {

    public IllegalHopperMaterialTypeException() {
    }

    public IllegalHopperMaterialTypeException(String message) {
        super(message);
    }
}
