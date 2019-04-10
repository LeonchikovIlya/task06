package by.epam.javawebtraining.leonchikov.task01.xml.parserFactory;

import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public abstract class AbstractBuilder {

    protected Set<Train> trains;

    public AbstractBuilder() {
        trains = new HashSet<>();
    }

    public Set<Train> getTrains() {
        return trains;
    }

    abstract public void buildTrainSet(String fileName);
}
