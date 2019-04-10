package by.epam.javawebtraining.leonchikov.task01.util.creator;


import by.epam.javawebtraining.leonchikov.task01.model.entity.PassengerTrain;
import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class PassengerTrainCreator implements AbstractCreator {
    @Override
    public PassengerTrain create() {
        return new PassengerTrain();
    }

}
