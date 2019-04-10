package by.epam.javawebtraining.leonchikov.task01.model.entity;

import by.epam.javawebtraining.leonchikov.task01.model.entity.consts.EntityConsts;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalFreightTrainValueException;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class FreightTrain extends Train {

    private int freightValue;

    public FreightTrain() {
        super();
        this.freightValue = DEFAULT_VALUE;
    }

    public FreightTrain(FreightTrain freightTrain) {
        super(freightTrain);
        this.freightValue = freightTrain.freightValue;
    }

    public FreightTrain(Object... objects) {
        this((String) objects[0], (int) objects[1], (int) objects[2], (TrainType) objects[3], (int) objects[4]);
    }

    public FreightTrain(String name, int maxSpeed, int wagonNumber, TrainType trainType, int freightValue) {
        super(name, maxSpeed, wagonNumber, trainType);
        this.freightValue = freightValue;
    }

    public void setFreightValue(int freightValue) throws IllegalFreightTrainValueException {

        if (freightValue >= 0) {
            this.freightValue = freightValue;
        } else {
            throw new IllegalFreightTrainValueException("Freight value must be pozitive");
        }
    }

    public int getFreightValue() {
            return this.freightValue;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = PRIME * result + this.freightValue;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        FreightTrain freightTrain = (FreightTrain) obj;
        return (super.equals(obj)) && (freightTrain.freightValue == this.freightValue);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + EntityConsts.FREIGHT_VALUE + " : " + this.freightValue;
    }

 /*   @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(freightValue);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        freightValue = in.readInt();
    } */
}
