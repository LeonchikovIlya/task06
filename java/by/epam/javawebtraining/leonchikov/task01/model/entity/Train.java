package by.epam.javawebtraining.leonchikov.task01.model.entity;

import by.epam.javawebtraining.leonchikov.task01.model.entity.consts.EntityConsts;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalTrainMaxSpeedException;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalTrainNameException;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalTrainTypeException;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalTrainWagonNumberException;

import java.io.*;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Train implements Serializable {

    static final int DEFAULT_VALUE = 0;
    static final String DEFAULT_NAME = "Unknown train";

    private String name;
    private int maxSpeed;
    private int wagonNumber;
    private TrainType trainType;

    public enum TrainType {
        PASSENGER("passenger"), FREIGHT("freight"), HIGHSPEED("highSpeed"), HOPPER("hopper"), UNKNOWN("unknown");

        private String value;

        TrainType(String string) {
            this.value = string;
        }

        public String getValue() {
            return value;
        }

    }

    public Train() {
        this.name = DEFAULT_NAME;
        this.maxSpeed = DEFAULT_VALUE;
        this.wagonNumber = DEFAULT_VALUE;
        this.trainType = TrainType.UNKNOWN;
    }

    public Train(Object... objects) {
        this((String) objects[0], (int) objects[1], (int) objects[2], (TrainType) objects[3]);
    }

    public Train(Train train) {
        this.name = train.name;
        this.maxSpeed = train.maxSpeed;
        this.wagonNumber = train.wagonNumber;
        this.trainType = train.trainType;
    }

    public Train(String name, int maxSpeed, int wagonNumber, TrainType trainType) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.wagonNumber = wagonNumber;
        this.trainType = trainType;
    }

    public void setName(String name) throws IllegalTrainNameException {

        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalTrainNameException("Excpected not null train name");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setMaxSpeed(int maxSpeed) throws IllegalTrainMaxSpeedException {

        if (maxSpeed >= 0) {
            this.maxSpeed = maxSpeed;
        } else {
            throw new IllegalTrainMaxSpeedException("Max speed must be pozitive");
        }
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getWagonNumber() {
        return wagonNumber;
    }

    public void setWagonNumber(int wagonNumber) throws IllegalTrainWagonNumberException {

        if (wagonNumber >= 0) {
            this.wagonNumber = wagonNumber;
        } else {
            throw new IllegalTrainWagonNumberException("Wagon number must be pozitive");
        }
    }

    public void setTrainType(TrainType trainType) throws IllegalTrainTypeException {

        if (trainType != null) {
            this.trainType = trainType;
        } else {
            throw new IllegalTrainTypeException("Expected not null train type");
        }
    }

    public TrainType getTrainType() {
        return trainType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Train train = (Train) obj;
        return (train.name.equalsIgnoreCase(this.name)) && (train.wagonNumber == this.wagonNumber)
                && (train.maxSpeed == this.maxSpeed) && (train.trainType == this.trainType);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.name.hashCode();
        result = PRIME * result + this.maxSpeed;
        result = PRIME * result + this.wagonNumber;
        result = PRIME * result + ((this.trainType == null) ? 0 : this.trainType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return EntityConsts.NAME + "='" + name + '\'' +
                ", " + EntityConsts.MAX_SPEED + "=" + maxSpeed +
                ", " + EntityConsts.WAGON_NUMBER + "=" + wagonNumber +
                ", " + EntityConsts.TRAIN_TYPE + "=" + trainType;
    }

 /*   @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(maxSpeed);
        out.writeInt(wagonNumber);
        out.writeObject(trainType);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        maxSpeed = in.readInt();
        wagonNumber = in.readInt();
        trainType = (TrainType) in.readObject();
    } */

}
