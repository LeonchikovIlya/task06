package by.epam.javawebtraining.leonchikov.task01.util.creator;


import by.epam.javawebtraining.leonchikov.task01.model.entity.Hopper;
import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class HopperCreator implements AbstractCreator {
    @Override
    public Hopper create() {
        return new Hopper();
    }

}
