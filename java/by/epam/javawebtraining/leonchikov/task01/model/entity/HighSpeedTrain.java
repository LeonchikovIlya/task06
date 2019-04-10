package by.epam.javawebtraining.leonchikov.task01.model.entity;


import by.epam.javawebtraining.leonchikov.task01.model.entity.consts.EntityConsts;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalHighSpeedTrainWagonTypeTypeException;

import java.util.Objects;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class HighSpeedTrain extends PassengerTrain {

    private WagonType wagonType;

    public enum WagonType {
        COMMON, SECOND_CLASS, FIRST_CLASS, UNKNOWN
    }

    public HighSpeedTrain() {
        super();
        this.wagonType = WagonType.UNKNOWN;
    }

    public HighSpeedTrain(HighSpeedTrain highSpeed) {
        super(highSpeed);
        this.wagonType = highSpeed.wagonType;
    }

    public HighSpeedTrain(Object... objects) {
        this((String) objects[0], (int) objects[1], (int) objects[2], (TrainType) objects[3], (int) objects[4]
                , (WagonType) objects[5]);
    }

    public HighSpeedTrain(String name, int maxSpeed, int wagonNumber, TrainType trainType, int passengerValue
            , WagonType wagonType) {
        super(name, maxSpeed, wagonNumber, trainType, passengerValue);
        this.wagonType = wagonType;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    public void setWagonType(WagonType wagonType) throws IllegalHighSpeedTrainWagonTypeTypeException {

        if (wagonType != null) {
            this.wagonType = wagonType;
        } else {
            throw new IllegalHighSpeedTrainWagonTypeTypeException();
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
        HighSpeedTrain that = (HighSpeedTrain) o;
        return (super.equals(o)) && (wagonType == that.wagonType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wagonType);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + EntityConsts.WAGON_TYPE + "=" + wagonType;
    }

  /*  @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeObject(wagonType);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        wagonType = (WagonType) in.readObject();
    } */
}
