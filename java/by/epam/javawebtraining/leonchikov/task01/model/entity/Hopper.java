package by.epam.javawebtraining.leonchikov.task01.model.entity;


import by.epam.javawebtraining.leonchikov.task01.model.entity.consts.EntityConsts;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalHopperMaterialTypeException;

import java.util.Objects;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Hopper extends FreightTrain {

    private Material material;

    public enum Material {
        LOOSE, SINGLE_PEACE, UNKNOWN
    }

    public Hopper() {
        super();
        this.material = Material.UNKNOWN;
    }

    public Hopper(Hopper hopper) {
        super(hopper);
        this.material = hopper.material;
    }

    public Hopper(Object... objects) {
        this((String)objects[0], (int) objects[1], (int) objects[2], (TrainType) objects[3], (int) objects[4]
                , (Material) objects[5]);
    }

    public Hopper(String name, int maxSpeed, int wagonNumber, TrainType trainType, int freightValue
            , Material material) {
        super(name, maxSpeed, wagonNumber, trainType, freightValue);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) throws IllegalHopperMaterialTypeException {

        if (material != null) {
            this.material = material;
        } else {
            throw new IllegalHopperMaterialTypeException();
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

        Hopper hopper = (Hopper) o;
        return (super.equals(o)) && (material == hopper.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + EntityConsts.MATERIAL + "=" + material;
    }

 /*   @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeObject(material);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        material = (Material)in.readObject();
    } */
}
