package by.epam.javawebtraining.leonchikov.task01.xml.stAx;

import by.epam.javawebtraining.leonchikov.task01.model.entity.*;
import by.epam.javawebtraining.leonchikov.task01.model.exception.LogicalException;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.IllegalTrainNameException;
import by.epam.javawebtraining.leonchikov.task01.xml.TrainCharacteristicsEnum;
import by.epam.javawebtraining.leonchikov.task01.xml.dom.TrainDOMBuilder;
import by.epam.javawebtraining.leonchikov.task01.xml.parserFactory.AbstractBuilder;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TrainStAxBuilder extends AbstractBuilder {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger("StAXLogger");
    }

    private XMLInputFactory inputFactory;

    private TrainStAxBuilder() {
        this.trains = new HashSet<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    private static class SingletonHolder{
        private static final TrainStAxBuilder INSTANCE = new TrainStAxBuilder();
    }

    public static TrainStAxBuilder getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void buildTrainSet(String fileName) {

        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name = "";

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    LOGGER.debug("Read line with such string :" + name);

                    if (check(name)) {
                        Train train = buildTrain(reader);
                        trains.add(train);
                        LOGGER.debug("Train " + train + " was added to railwayStation");
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex);
        } catch (LogicalException e) {
            LOGGER.error("There is some problems with train values");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private boolean check(String string) {

        boolean result = false;

        for (Train.TrainType s : Train.TrainType.values()) {
            if (s.getValue().equalsIgnoreCase(string)) {
                result = true;
                return result;
            }
        }
        return result;
    }

    private Train buildTrain(XMLStreamReader reader) throws XMLStreamException, LogicalException {

        Train train;

        if (reader.getLocalName() == Train.TrainType.HIGHSPEED.getValue()) {
            train = new HighSpeedTrain();
        } else if (reader.getLocalName() == Train.TrainType.HOPPER.getValue()) {
            train = new Hopper();
        } else if (reader.getLocalName() == Train.TrainType.PASSENGER.getValue()) {
            train = new PassengerTrain();
        } else if (reader.getLocalName() == Train.TrainType.FREIGHT.getValue()) {
            train = new FreightTrain();
        } else {
            train = new Train();
        }

        String name = "";

        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TrainCharacteristicsEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            train.setName(getXMLText(reader));
                            break;
                        case MAXSPEED:
                            train.setMaxSpeed(Integer.parseInt(getXMLText(reader)));
                            break;
                        case WAGONNUMBER:
                            train.setWagonNumber(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TRAINTYPE:
                            train.setTrainType(Train.TrainType.valueOf(getXMLText(reader)));
                            break;
                        default:
                            if (train.getClass() == PassengerTrain.class) {

                                PassengerTrain passengerTrain = (PassengerTrain) train;

                                if (name == TrainCharacteristicsEnum.PASSENGERVALUE.getValue())
                                    passengerTrain.setPassengerValue(Integer.parseInt(getXMLText(reader)));

                            } else if (train.getClass() == FreightTrain.class) {

                                FreightTrain freightTrain = (FreightTrain) train;

                                if (name == TrainCharacteristicsEnum.FREIGHTVALUE.getValue())
                                    freightTrain.setFreightValue(Integer.parseInt(getXMLText(reader)));

                            } else if (train.getClass() == HighSpeedTrain.class) {

                                HighSpeedTrain highSpeedTrain = (HighSpeedTrain) train;

                                if (name == TrainCharacteristicsEnum.PASSENGERVALUE.getValue()) {
                                    highSpeedTrain.setPassengerValue(Integer.parseInt(getXMLText(reader)));

                                } else if (name == TrainCharacteristicsEnum.WAGONTYPE.getValue()) {
                                    highSpeedTrain.setWagonType(HighSpeedTrain.WagonType.valueOf(getXMLText(reader)));
                                }

                            } else if (train.getClass() == Hopper.class) {

                                Hopper hopper = (Hopper) train;

                                if (name == TrainCharacteristicsEnum.FREIGHTVALUE.getValue()) {
                                    hopper.setFreightValue(Integer.parseInt(getXMLText(reader)));

                                } else if (name == TrainCharacteristicsEnum.MATERIAL.getValue()) {
                                    hopper.setMaterial(Hopper.Material.valueOf(getXMLText(reader)));
                                }
                            }
                            break;
                    }

                case XMLStreamConstants.END_ELEMENT:

                    if (reader.isEndElement()) {

                        name = reader.getLocalName();
                        if (check(name)) {
                            return train;
                        }
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {

        String text = null;

        if (reader.hasNext()) {
            reader.next();
            text = reader.getText().trim();
        }
        return text;
    }
}