package by.epam.javawebtraining.leonchikov.task01.model.entity;

import by.epam.javawebtraining.leonchikov.task01.model.entity.consts.EntityConsts;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalPassengerTrainValueException;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class PassengerTrain extends Train{

    private int passengerValue;

    public PassengerTrain() {
        super();
        this.passengerValue = DEFAULT_VALUE;
    }

    public PassengerTrain(PassengerTrain passengerTrain) {
        super(passengerTrain);
        this.passengerValue = passengerTrain.passengerValue;
    }

    public PassengerTrain(Object... objects) {
        this((String) objects[0], (int) objects[1], (int) objects[2], (TrainType) objects[3], (int) objects[4]);
    }

    public PassengerTrain(String name, int maxSpeed, int wagonNumber, TrainType trainType, int passengerValue) {
        super(name, maxSpeed, wagonNumber, trainType);
        this.passengerValue = passengerValue;
    }

    public void setPassengerValue(int passengerValue) throws IllegalPassengerTrainValueException {

        if (passengerValue >= 0) {
            this.passengerValue = passengerValue;
        } else {
            throw new IllegalPassengerTrainValueException("Passenger value must be pozitive");
        }
    }

    public int getPassengerValue() {
        return this.passengerValue;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = PRIME * result + this.passengerValue;
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

        PassengerTrain passengerTrain = (PassengerTrain) obj;
        return (super.equals(obj)) && (passengerTrain.passengerValue == this.passengerValue);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + EntityConsts.PASSENGER_VALUE + "=" + passengerValue;
    }

 /*   @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(passengerValue);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        passengerValue = in.readInt();
    } */
}
