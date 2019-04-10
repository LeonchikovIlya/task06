package by.epam.javawebtraining.leonchikov.task01.util.creator;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TrainCreator {

    public enum CreatorType {
        PASSENGER, FREIGHT, HOPPER, HIGHSPEED
    }

    public static AbstractCreator createTrain(CreatorType type) {

        AbstractCreator abstractCreator = new PassengerTrainCreator();

        switch (type) {
            case HOPPER:
                abstractCreator = new HopperCreator();
                break;
            case FREIGHT:
                abstractCreator = new FreightTrainCreator();
                break;
            case HIGHSPEED:
                abstractCreator = new HighSpeedTrainCreator();
                break;
        }
        return abstractCreator;
    }
}
