package by.epam.javawebtraining.leonchikov.task01.util.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class ConfigFileReader {

    public static final String PATH_TO_PROPERTIES;
    private static Properties prop;

    static{
        PATH_TO_PROPERTIES = "src/main/resources/configuration.properties";
        prop = new Properties();
    }

    public static String getProperty(String property) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(property);
    }

}
