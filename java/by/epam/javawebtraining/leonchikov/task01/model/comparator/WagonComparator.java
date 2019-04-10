package by.epam.javawebtraining.leonchikov.task01.model.comparator;


import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

import java.util.Comparator;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class WagonComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        return o2.getWagonNumber() - o1.getWagonNumber();
    }
}
