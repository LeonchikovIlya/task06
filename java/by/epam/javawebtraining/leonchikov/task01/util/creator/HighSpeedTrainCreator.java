package by.epam.javawebtraining.leonchikov.task01.util.creator;


import by.epam.javawebtraining.leonchikov.task01.model.entity.HighSpeedTrain;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class HighSpeedTrainCreator implements AbstractCreator {
    @Override
    public HighSpeedTrain create() {
        return new HighSpeedTrain();
    }

}
