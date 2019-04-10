package by.epam.javawebtraining.leonchikov.task01.util.Validator;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Validator {

    public static boolean isValidText(String text) {
        return text != null && text.matches("(\\w)+");
    }

    public static boolean isValidNumber(String number) {
        return number != null && number.matches("(\\d)+");
    }

    public static boolean isValidTrainType(String type) {

        boolean result = false;

        if (type != null) {
            if (type.equalsIgnoreCase("Passenger") || type.equalsIgnoreCase("Freight")
                    || type.equalsIgnoreCase("Highspeed") || type.equalsIgnoreCase("Hopper")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isValidMaterialType(String type) {

        boolean result = false;

        if (type != null) {
            if (type.equalsIgnoreCase("Loose") || type.equalsIgnoreCase("Single_peace")
                    || type.equalsIgnoreCase("Unknown")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isValidWagonType(String type) {

        boolean result = false;

        if (type != null) {
            if (type.equalsIgnoreCase("Common") || type.equalsIgnoreCase("Second_class")
                    || type.equalsIgnoreCase("First_class") || type.equalsIgnoreCase("Unknown")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isValidPassengerTrain(String[] args) {

        return args != null && isValidText(args[1]) && isValidNumber(args[2]) && isValidNumber(args[3])
                && isValidTrainType(args[0]) && isValidNumber(args[4]);
    }

    public static boolean isValidHighSpeedTrain(String[] args) {

        return args != null && isValidText(args[1]) && isValidNumber(args[2]) && isValidNumber(args[3])
                && isValidTrainType(args[0]) && isValidNumber(args[4]) && isValidWagonType(args[5]);
    }

    public static boolean isValidFreightTrain(String[] args) {

        return args != null && isValidText(args[1]) && isValidNumber(args[2]) && isValidNumber(args[3])
                && isValidTrainType(args[0]) && isValidNumber(args[4]);
    }

    public static boolean isValidHopper(String[] args) {

        return args != null && isValidText(args[1]) && isValidTrainType(args[0])
                && isValidNumber(args[2]) && isValidNumber(args[3])
                && isValidNumber(args[4]) && isValidMaterialType(args[5]);
    }



}
