package by.epam.javawebtraining.leonchikov.task01.util.Serializator;

import by.epam.javawebtraining.leonchikov.task01.model.entity.Train;

import java.io.*;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TrainSerializator {

    public static void write(Train train, String fileName) {

        try (ObjectOutputStream stream = new ObjectOutputStream
                (new BufferedOutputStream
                        (new FileOutputStream(fileName, true)))) {

            stream.writeObject(train);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Train read(String fileName) {

        Train train = null;

        try (ObjectInputStream stream = new ObjectInputStream
                (new BufferedInputStream
                        (new FileInputStream(fileName)))) {

            train = (Train) stream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return train;
    }
}
