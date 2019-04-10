package by.epam.javawebtraining.leonchikov.task01.controller;

import by.epam.javawebtraining.leonchikov.task01.util.config.ConfigFileReader;
import by.epam.javawebtraining.leonchikov.task01.xml.parserFactory.AbstractBuilder;
import by.epam.javawebtraining.leonchikov.task01.xml.parserFactory.BuilderFactory;
import by.epam.javawebtraining.leonchikov.task01.xml.validator.ValidatorXML;
import org.apache.log4j.Logger;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Controller {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger("MainLogger");
    }

    public static void main(String[] args) {

        String pathXML = ConfigFileReader.getProperty("pathXML");
        String pathXSD = ConfigFileReader.getProperty("pathXSD");

        ValidatorXML.validate(pathXML, pathXSD);

        BuilderFactory factory = new BuilderFactory();

        AbstractBuilder DOMBuilder = factory.createBuilder(BuilderFactory.BuilderType.DOM);
        DOMBuilder.buildTrainSet(pathXML);
        LOGGER.info(DOMBuilder.getTrains());

        AbstractBuilder SAXBuilder = factory.createBuilder(BuilderFactory.BuilderType.SAX);
        SAXBuilder.buildTrainSet(pathXML);
        LOGGER.info(SAXBuilder.getTrains());

        AbstractBuilder StAXBuilder = factory.createBuilder(BuilderFactory.BuilderType.STAX);
        StAXBuilder.buildTrainSet(pathXML);
        LOGGER.info(StAXBuilder.getTrains());

    }

}
