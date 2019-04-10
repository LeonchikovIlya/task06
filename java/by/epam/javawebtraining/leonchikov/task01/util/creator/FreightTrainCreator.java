package by.epam.javawebtraining.leonchikov.task01.util.creator;


import by.epam.javawebtraining.leonchikov.task01.model.entity.FreightTrain;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class FreightTrainCreator implements AbstractCreator {

    @Override
    public FreightTrain create() {
        return new FreightTrain();
    }

}
