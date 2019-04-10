package by.epam.javawebtraining.leonchikov.task01.model.entity.consts;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class EntityConsts {

    private static ResourceBundle resourceBundle;
    private static Locale locale;

    static {
        changeLocale(Locale.getDefault());
    }

    public static String NAME;
    public static String MAX_SPEED;
    public static String WAGON_NUMBER;
    public static String TRAIN_TYPE;
    public static String PASSENGER_VALUE;
    public static String FREIGHT_VALUE;
    public static String MATERIAL;
    public static String WAGON_TYPE;

    public static void changeLocale(Locale locale) {

        resourceBundle = ResourceBundle.getBundle("localization.llon",locale);

        NAME = resourceBundle.getString("Name");
        MAX_SPEED = resourceBundle.getString("Max_speed");
        WAGON_NUMBER = resourceBundle.getString("Wagon_number");
        TRAIN_TYPE = resourceBundle.getString("Train_type");
        PASSENGER_VALUE = resourceBundle.getString("Passenger_value");
        FREIGHT_VALUE = resourceBundle.getString("Freight_value");
        MATERIAL = resourceBundle.getString("Material");
        WAGON_TYPE = resourceBundle.getString("Wagon_type");

    }
}
