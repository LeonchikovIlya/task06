package by.epam.javawebtraining.leonchikov.task01.util.Reader;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Reader {

    private static final Logger logger;

    static{
        logger = Logger.getRootLogger();
    }

    public static String readFromFile(String path) {

        StringBuilder stringBuilder = new StringBuilder();

        if (path != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String separator = "\n";
                String str;
                while ((str = br.readLine()) != null) {
                    stringBuilder.append(str).append(separator);
                }
                logger.info("Text had been read successful");
            } catch (IOException e) {
                logger.warn(e.getMessage());
            }
        }
        return stringBuilder.toString();
    }
}
