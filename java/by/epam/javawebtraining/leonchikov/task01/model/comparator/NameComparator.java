package by.epam.javawebtraining.leonchikov.task01.model.comparator;


import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

import java.util.Comparator;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class NameComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
