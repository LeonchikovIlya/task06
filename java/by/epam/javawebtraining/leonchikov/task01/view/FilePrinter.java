package by.epam.javawebtraining.leonchikov.task01.view;


import by.epam.javawebtraining.leonchikov.task01.model.logic.Finder;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class FilePrinter implements Printable {

    private static final Logger logger;

    static{
        logger = Logger.getRootLogger();
    }

    private final String DEFAULT_PATH = "C:\\Users\\User\\IdeaProjects\\Pro\\src\\main\\java\\by\\epam"
            + "\\javawebtraining\\leonchikov\\task01\\util\\output\\output";

    private File file;

    public FilePrinter() {
        file = new File(DEFAULT_PATH);
    }

    public FilePrinter(String fileName) {
        if (fileName != null) {
            file = new File(fileName);
        }
    }

    @Override
    public void print(Object obj) {

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.write(obj + "");
            pw.flush();
            logger.info("Data had been written in file");
        } catch (IOException e) {
            logger.warn(e.getMessage());
        } finally {
            if (pw != null) {
                try {
                    pw.close();
                } catch (Exception e) {
                    logger.warn(e.getMessage());
                }
            }
        }
    }
}

