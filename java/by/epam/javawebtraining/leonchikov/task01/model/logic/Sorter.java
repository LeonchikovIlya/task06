package by.epam.javawebtraining.leonchikov.task01.model.logic;


import by.epam.javawebtraining.leonchikov.task01.model.comparator.NameComparator;
import by.epam.javawebtraining.leonchikov.task01.model.comparator.SpeedComparator;
import by.epam.javawebtraining.leonchikov.task01.model.comparator.WagonComparator;
import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;
import by.epam.javawebtraining.leonchikov.task01.model.container.RailwayStation;

import java.util.Arrays;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Sorter {

    public static Train[] bySpeed(RailwayStation railwayStation) {

        Train[] trainArray = null;
        if (railwayStation != null && railwayStation.getTrainArray()[0] != null) {
            trainArray = railwayStation.getTrainArray();
            Arrays.sort(trainArray, new SpeedComparator());
        }
        return trainArray;
    }

    public static Train[] byName(RailwayStation railwayStation) {

        Train[] trainArray = null;
        if (railwayStation != null && railwayStation.getTrainArray()[0] != null) {
            trainArray = railwayStation.getTrainArray();
            Arrays.sort(trainArray, new NameComparator());
        }
        return trainArray;
    }

    public static Train[] byWagon(RailwayStation railwayStation) {

        Train[] trainArray = null;
        if (railwayStation != null && railwayStation.getTrainArray()[0] != null) {
            trainArray = railwayStation.getTrainArray();
            Arrays.sort(trainArray, new WagonComparator());
        }
        return trainArray;
    }

    public static Train[] bySpeedAndWagon(RailwayStation railwayStation) {

        Train[] trainArray = null;
        if (railwayStation != null && railwayStation.getTrainArray()[0] != null) {
            trainArray = railwayStation.getTrainArray();
            Arrays.sort(trainArray, new SpeedComparator().thenComparing(new WagonComparator()));
        }
        return trainArray;
    }
}

