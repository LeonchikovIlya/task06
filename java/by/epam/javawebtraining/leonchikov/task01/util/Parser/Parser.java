package by.epam.javawebtraining.leonchikov.task01.util.Parser;

import by.epam.javawebtraining.leonchikov.task01.model.container.RailwayStation;
import by.epam.javawebtraining.leonchikov.task01.model.entity.*;
import by.epam.javawebtraining.leonchikov.task01.model.exception.LogicalException;
import by.epam.javawebtraining.leonchikov.task01.util.Reader.Reader;
import by.epam.javawebtraining.leonchikov.task01.util.Validator.Validator;
import by.epam.javawebtraining.leonchikov.task01.util.creator.AbstractCreator;
import by.epam.javawebtraining.leonchikov.task01.util.creator.TrainCreator;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Parser {

    private static RailwayStation trains = new RailwayStation();

    private static AbstractCreator creator;

    public static RailwayStation totalTrainListFromFile(String path) {

        String[] lines = Reader.readFromFile(path).split("\n");
        String[] argsArray;

        for (String s : lines) {
            if (s.contains("Hopper") && Validator.isValidHopper(argsArray = s.split(" "))) {
                try {
                    hopperParser(argsArray);
                } catch (LogicalException e) {
                    e.printStackTrace();
                }
            }
            if (s.contains("Passenger") && Validator.isValidPassengerTrain(argsArray = s.split(" "))) {
                try {
                    passengerTrainParser(argsArray);
                } catch (LogicalException e) {
                    e.printStackTrace();
                }
            }
            if (s.contains("Highspeed") && Validator.isValidHighSpeedTrain(argsArray = s.split(" "))) {
                try {
                    highSpeedTrainParser(argsArray);
                } catch (LogicalException e) {
                    e.printStackTrace();
                }
            }
            if (s.contains("Freight") && Validator.isValidFreightTrain(argsArray = s.split(" "))) {
                try {
                    freightTrainParser(argsArray);
                } catch (LogicalException e) {
                    e.printStackTrace();
                }
            }

        }
        return trains;
    }

    /*    try {
            hopperParser(lines);
            freightTrainParser(lines);
            highSpeedTrainParser(lines);
            passengerTrainParser(lines);
        } catch (LogicalException e) {
            e.printStackTrace();
        }*/

    private static void hopperParser(String[] argsArray) throws LogicalException {

        Hopper hopper;
        /*for (String s : args) {
            if (s.contains("Hopper") && Validator.isValidHopper(argsArray = s.split(" "))) {
*/
        creator = TrainCreator.createTrain(TrainCreator.CreatorType.HOPPER);

        hopper = (Hopper) creator.create();

        hopper.setName(argsArray[1]);
        hopper.setMaxSpeed(Integer.parseInt(argsArray[2]));
        hopper.setWagonNumber(Integer.parseInt(argsArray[3]));
        hopper.setTrainType(trainTypeParser(argsArray[0]));
        hopper.setFreightValue(Integer.parseInt(argsArray[4]));
        hopper.setMaterial(trainMaterialParser(argsArray[5]));

        trains.addTrain(hopper);
        //  }
    }


    private static void passengerTrainParser(String[] argsArray) throws LogicalException {

        PassengerTrain passengerTrain;

      /*  for (String s : args) {
            if (s.contains("Passenger") && Validator.isValidPassengerTrain(argsArray = s.split(" "))) {*/

        creator = TrainCreator.createTrain(TrainCreator.CreatorType.HOPPER);

        passengerTrain = (PassengerTrain) creator.create();

        passengerTrain.setName(argsArray[1]);
        passengerTrain.setMaxSpeed(Integer.parseInt(argsArray[2]));
        passengerTrain.setWagonNumber(Integer.parseInt(argsArray[3]));
        passengerTrain.setTrainType(trainTypeParser(argsArray[0]));
        passengerTrain.setPassengerValue(Integer.parseInt(argsArray[4]));

        trains.addTrain(passengerTrain);
        //    }
    }

    private static void highSpeedTrainParser(String[] argsArray) throws LogicalException {

        HighSpeedTrain highSpeedTrain;

       /* for (String s : args) {
            if (s.contains("Highspeed") && Validator.isValidHighSpeedTrain(argsArray = s.split(" "))) {*/

        creator = TrainCreator.createTrain(TrainCreator.CreatorType.HOPPER);

        highSpeedTrain = (HighSpeedTrain) creator.create();

        highSpeedTrain.setName(argsArray[1]);
        highSpeedTrain.setMaxSpeed(Integer.parseInt(argsArray[2]));
        highSpeedTrain.setWagonNumber(Integer.parseInt(argsArray[3]));
        highSpeedTrain.setTrainType(trainTypeParser(argsArray[0]));
        highSpeedTrain.setPassengerValue(Integer.parseInt(argsArray[4]));
        highSpeedTrain.setWagonType(wagonTypeParser(argsArray[5]));

        trains.addTrain(highSpeedTrain);
    }

    private static void freightTrainParser(String[] argsArray) throws LogicalException {

        FreightTrain freightTrain;

  /*      for (String s : args) {
            if (s.contains("Freight") && Validator.isValidFreightTrain(argsArray = s.split(" "))) {*/

        creator = TrainCreator.createTrain(TrainCreator.CreatorType.FREIGHT);

        freightTrain = (FreightTrain) creator.create();

        freightTrain.setName(argsArray[1]);
        freightTrain.setMaxSpeed(Integer.parseInt(argsArray[2]));
        freightTrain.setWagonNumber(Integer.parseInt(argsArray[3]));
        freightTrain.setTrainType(trainTypeParser(argsArray[0]));
        freightTrain.setFreightValue(Integer.parseInt(argsArray[4]));

        trains.addTrain(freightTrain);
    }

    private static Train.TrainType trainTypeParser(String arg) {
        return Train.TrainType.valueOf(arg.toUpperCase());
    }

    private static Hopper.Material trainMaterialParser(String arg) {
        return Hopper.Material.valueOf(arg.toUpperCase());
    }

    private static HighSpeedTrain.WagonType wagonTypeParser(String arg) {
        return HighSpeedTrain.WagonType.valueOf(arg.toUpperCase());
    }
}
