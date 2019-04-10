package by.epam.javawebtraining.leonchikov.task01.xml.sax;

import by.epam.javawebtraining.leonchikov.task01.xml.parserFactory.AbstractBuilder;
import by.epam.javawebtraining.leonchikov.task01.xml.stAx.TrainStAxBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.HashSet;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TrainSaXBuilder extends AbstractBuilder {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger("SaXLogger");
    }

    private TrainHandler handler;
    private XMLReader reader;

    private TrainSaXBuilder() {
        this.trains = new HashSet<>();
        handler = new TrainHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error : " + e);
        }
    }

    private static class SingletonHolder{
        private static final TrainSaXBuilder INSTANCE = new TrainSaXBuilder();
    }

    public static TrainSaXBuilder getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void buildTrainSet(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error : " + e);
        } catch (IOException e) {
            LOGGER.error("I/О thread error : " + e);
        }
        trains = handler.getTrains();
    }
}
