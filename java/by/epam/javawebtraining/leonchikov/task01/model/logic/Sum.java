package by.epam.javawebtraining.leonchikov.task01.model.logic;


import by.epam.javawebtraining.leonchikov.task01.model.container.RailwayStation;
import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Sum {

    public static int trainPassenger(RailwayStation railwayStation) {

        int count = -1;
        if (railwayStation != null) {
            Train[] trainArray = railwayStation.getTrainArray();
            if (trainArray[0] != null) {
                count = 0;
                for (int i = 0; i < railwayStation.getCurrentTrainCount(); i++) {
                    if (trainArray[i].getTrainType() == Train.TrainType.PASSENGER
                    || trainArray[i].getTrainType() == Train.TrainType.HIGHSPEED) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int trainWagon(RailwayStation railwayStation) {

        int sum = -1;
        if (railwayStation != null) {
            Train[] trainArray = railwayStation.getTrainArray();
            if (trainArray[0] != null) {
                sum = 0;
                for (int i = 0; i < railwayStation.getCurrentTrainCount(); i++) {
                    sum += trainArray[i].getWagonNumber();
                }
            }
        }
        return sum;
    }


}
