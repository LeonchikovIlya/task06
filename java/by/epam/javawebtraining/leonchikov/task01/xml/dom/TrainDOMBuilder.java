package by.epam.javawebtraining.leonchikov.task01.xml.dom;

import by.epam.javawebtraining.leonchikov.task01.model.entity.*;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.*;
import by.epam.javawebtraining.leonchikov.task01.xml.TrainCharacteristicsEnum;
import by.epam.javawebtraining.leonchikov.task01.xml.parserFactory.AbstractBuilder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TrainDOMBuilder extends AbstractBuilder {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger("DOMLogger");
    }

    private DocumentBuilder docBuilder;

    private TrainDOMBuilder() {
        this.trains = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("DOM parser configuration error " + e);
        }
    }

    private static class SingletonHolder{
        private static final TrainDOMBuilder INSTANCE = new TrainDOMBuilder();
    }

    public static TrainDOMBuilder getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void buildTrainSet(String fileName) {

        Document doc = null;

        try {

            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList trainList = root.getChildNodes();

            for (int i = 0; i < trainList.getLength(); i++) {

                if (trainList.item(i) instanceof Element) {

                    Element trainElement = (Element) trainList.item(i);
                    Train train = buildTrain(trainElement);

                    trains.add(train);

                    LOGGER.info("Current trainList : " + trains);

                }
            }
        } catch (IOException e) {
            LOGGER.error("File error or I/O error: " + e);
        } catch (org.xml.sax.SAXException e) {
            LOGGER.error("Parsing failure: " + e);
        }
    }

    private Train buildTrain(Element trainElement) {

        String element = trainElement.getNodeName();
        Train.TrainType trainType = Train.TrainType.valueOf(element.toUpperCase());
        Train train;

        switch (trainType) {

            case PASSENGER:

                train = new PassengerTrain();
                PassengerTrain passengerTrain = (PassengerTrain) train;
                try {
                    passengerTrain.setPassengerValue(Integer.parseInt(getElementTextContent(trainElement
                            , TrainCharacteristicsEnum.PASSENGERVALUE.getValue())));
                } catch (IllegalPassengerTrainValueException e) {
                    LOGGER.error("Illegal passenger value " + e);
                }
                break;

            case HOPPER:

                train = new Hopper();
                Hopper hopper = (Hopper) train;
                try {

                    hopper.setFreightValue(Integer.parseInt(getElementTextContent(trainElement
                            , TrainCharacteristicsEnum.FREIGHTVALUE.getValue())));

                    hopper.setMaterial(Hopper.Material.valueOf(getElementTextContent(trainElement
                            , TrainCharacteristicsEnum.MATERIAL.getValue())));
                } catch (IllegalFreightTrainValueException | IllegalHopperMaterialTypeException e) {
                    LOGGER.error("Illegal freigt value or material " + e);
                }
                break;

            case HIGHSPEED:

                train = new HighSpeedTrain();
                HighSpeedTrain highspeed = (HighSpeedTrain) train;
                try {

                    highspeed.setPassengerValue(Integer.parseInt(getElementTextContent(trainElement
                            , TrainCharacteristicsEnum.PASSENGERVALUE.getValue())));

                    highspeed.setWagonType(HighSpeedTrain.WagonType.valueOf(getElementTextContent(trainElement
                            , TrainCharacteristicsEnum.WAGONTYPE.getValue())));
                } catch (IllegalHighSpeedTrainWagonTypeTypeException | IllegalPassengerTrainValueException e) {
                    LOGGER.error("Illegal passenger value or wagon type " + e);
                }
                break;

            case FREIGHT:

                train = new FreightTrain();
                FreightTrain freight = (FreightTrain) train;
                try {
                    freight.setFreightValue(Integer.parseInt(getElementTextContent(trainElement
                            , TrainCharacteristicsEnum.FREIGHTVALUE.getValue())));
                } catch (IllegalFreightTrainValueException e) {
                    LOGGER.error("Illegal freigt value " + e);
                }
                break;

            default:
                train = null;
                break;
        }
        if (train != null) {
            try {
                train.setName(getElementTextContent(trainElement, TrainCharacteristicsEnum.NAME.getValue()));
                train.setMaxSpeed(Integer.parseInt(getElementTextContent(trainElement
                        , TrainCharacteristicsEnum.MAXSPEED.getValue())));
                train.setWagonNumber(Integer.parseInt(getElementTextContent(trainElement
                        , TrainCharacteristicsEnum.WAGONNUMBER.getValue())));
                train.setTrainType(Train.TrainType.valueOf(getElementTextContent(trainElement
                        , TrainCharacteristicsEnum.TRAINTYPE.getValue())));
            } catch (IllegalTrainNameException | IllegalTrainMaxSpeedException | IllegalTrainTypeException
                    | IllegalTrainWagonNumberException e) {
                LOGGER.error("Illegal name\\maxSpeed\\trainType\\wagonNumber " + e);
            }
        }

        return train;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
