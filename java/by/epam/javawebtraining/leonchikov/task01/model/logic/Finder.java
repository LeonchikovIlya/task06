package by.epam.javawebtraining.leonchikov.task01.model.logic;


import by.epam.javawebtraining.leonchikov.task01.model.container.RailwayStation;
import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Finder {

    public static Train fastestTrain(RailwayStation railwayStation) {

        Train train = null;
        if (railwayStation != null) {
            Train[] trainArray = railwayStation.getTrainArray();
            if (trainArray[0] != null) {
                int max = trainArray[0].getMaxSpeed();
                train = trainArray[0];
                for (int i = 1; i < railwayStation.getCurrentTrainCount(); i++) {
                    if (max < trainArray[i].getMaxSpeed()) {
                        max = trainArray[i].getMaxSpeed();
                        train = trainArray[i];
                    }
                }
            }
        }
        return train;
    }

    public static int indexOfFastestTrain(RailwayStation railwayStation) {

        int indexOfMax = -1;
        if (railwayStation != null) {
            Train[] trainArray = railwayStation.getTrainArray();
            if (trainArray[0] != null) {
                indexOfMax = 0;
                for (int i = 1; i < railwayStation.getCurrentTrainCount(); i++) {
                    if (trainArray[i].getMaxSpeed() > trainArray[indexOfMax].getMaxSpeed()) {
                        indexOfMax = i;
                    }
                }
            }
        }
        return indexOfMax;
    }

    public static Train slowestTrain(RailwayStation railwayStation) {

        Train train = null;
        if (railwayStation != null) {
            Train[] trainArray = railwayStation.getTrainArray();
            if (trainArray[0] != null) {
                int min = trainArray[0].getMaxSpeed();
                train = trainArray[0];
                for (int i = 1; i < railwayStation.getCurrentTrainCount(); i++) {
                    if (min > trainArray[i].getMaxSpeed()) {
                        min = trainArray[i].getMaxSpeed();
                        train = trainArray[i];
                    }
                }
            }
        }
        return train;
    }

    public static int indexOfSlowestTrain(RailwayStation railwayStation) {

        int indexOfMin = -1;
        if (railwayStation != null) {
            Train[] trainArray = railwayStation.getTrainArray();
            if (trainArray[0] != null) {
                indexOfMin = 0;
                for (int i = 1; i < railwayStation.getCurrentTrainCount(); i++) {
                    if (trainArray[i].getMaxSpeed() < trainArray[indexOfMin].getMaxSpeed()) {
                        indexOfMin = i;
                    }
                }
            }
        }
        return indexOfMin;
    }
}
