package by.epam.javawebtraining.leonchikov.task01.model.container;


import by.epam.javawebtraining.leonchikov.task01.model.entity.*;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalRwCapacityException;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.NoPlaceInRwException;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class RailwayStation {

    private static final int MAX_CAPACITY = 25;
    private static final int DEFAULT_CAPACITY = 1;

    private int currentTrainCount = 0;
    private int capacity;
    private Train[] trainArray;

    public RailwayStation() {
        this.capacity = DEFAULT_CAPACITY;
        this.trainArray = new Train[capacity];
    }

    public RailwayStation(int capacity) {

        if (capacity > 0 && capacity <= MAX_CAPACITY) {
            this.capacity = capacity;
            trainArray = new Train[capacity];
        }
    }

    public RailwayStation(RailwayStation railwayStation) {
        this.currentTrainCount = railwayStation.currentTrainCount;
        this.capacity = railwayStation.capacity;
        this.trainArray = new Train[this.capacity];

        for (int i = 0; i < railwayStation.getCapacity(); i++) {

            if (railwayStation.getTrainArray()[0] != null) {

                switch (railwayStation.getTrainArray()[i].getTrainType()) {

                    case PASSENGER:
                        this.trainArray[i] = new PassengerTrain((PassengerTrain) railwayStation.trainArray[i]);
                        break;

                    case FREIGHT:
                        this.trainArray[i] = new FreightTrain((FreightTrain) railwayStation.trainArray[i]);
                        break;

                    case HIGHSPEED:
                        this.trainArray[i] = new HighSpeedTrain((HighSpeedTrain) railwayStation.trainArray[i]);
                        break;

                    case HOPPER:
                        this.trainArray[i] = new Hopper((Hopper) railwayStation.trainArray[i]);
                        break;

                    default:
                        this.trainArray[i] = new Train((Train) railwayStation.trainArray[i]);
                        break;
                }
            }

        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int setCapacity(int capacity) throws IllegalRwCapacityException {

        if (capacity > 0 && capacity <= MAX_CAPACITY) {
            return this.capacity = capacity;
        }
        throw new IllegalRwCapacityException();
    }

    public Train[] getTrainArray() {
        return trainArray;
    }

    public int getCurrentTrainCount() {
        return currentTrainCount;
    }

    public void addTrain(Train train) {

        if (train != null) {
            if (currentTrainCount < trainArray.length) {
                trainArray[currentTrainCount] = train;
                currentTrainCount++;
            } else {
                try {
                    increaseArraySize(train);
                } catch (NoPlaceInRwException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void increaseArraySize(Train train) throws NoPlaceInRwException {

        if (currentTrainCount < MAX_CAPACITY) {
            int oldCapacity = trainArray.length;
            capacity = oldCapacity + 1;
            trainArray = Arrays.copyOf(trainArray, capacity);
            trainArray[currentTrainCount] = train;
            currentTrainCount++;
        } else {
            throw new NoPlaceInRwException("RailwayStation is full " + currentTrainCount);
        }
    }

    public void removeTrain(Train train) {

        if (train != null) {
            int j = 0;

            for (int i = 0; i < trainArray.length; i++) {
                if (train.equals(trainArray[i])) {
                    j = i;
                }
            }
            removeByIndex(j);
            //   reduceArraySize();
            capacity--;
        }
    }

    private void reduceArraySize() {

        if (currentTrainCount <= MAX_CAPACITY) {
            int oldCapacity = trainArray.length;
            trainArray = Arrays.copyOf(trainArray, oldCapacity - 1);
        }
    }

    public void removeByIndex(int index) {

        if (index >= 0 && index < currentTrainCount) {
            if (index != currentTrainCount - 1) {
                int lastIndexOf = 0;
                for (int i = index; i < currentTrainCount - 1; i++) {
                    trainArray[i] = trainArray[i + 1];
                    lastIndexOf = i + 1;
                }
                trainArray[lastIndexOf] = null;
                currentTrainCount--;
            } else {
                trainArray[index] = null;
                currentTrainCount--;
            }
            reduceArraySize();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RailwayStation that = (RailwayStation) o;
        return currentTrainCount == that.currentTrainCount &&
                capacity == that.capacity &&
                Arrays.equals(trainArray, that.trainArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentTrainCount, capacity);
        result = 31 * result + Arrays.hashCode(trainArray);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Train aTrainArray : trainArray) {
            builder.append(aTrainArray).append("\n");
        }
        return builder + "";
    }
}


