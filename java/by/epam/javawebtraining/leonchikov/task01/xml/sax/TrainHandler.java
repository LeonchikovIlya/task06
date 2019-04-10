package by.epam.javawebtraining.leonchikov.task01.xml.sax;

import by.epam.javawebtraining.leonchikov.task01.model.entity.*;
import by.epam.javawebtraining.leonchikov.task01.model.exception.logicException.*;
import by.epam.javawebtraining.leonchikov.task01.xml.TrainCharacteristicsEnum;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TrainHandler extends DefaultHandler {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger("SaXLogger");
    }

    private Set<Train> trains;

    private Train current = null;
    private TrainCharacteristicsEnum currentEnum = null;
    private EnumSet<TrainCharacteristicsEnum> types;
    private EnumSet<TrainCharacteristicsEnum> fields;

    public TrainHandler() {
        trains = new HashSet<Train>();
        fields = EnumSet.range(TrainCharacteristicsEnum.RAILWAYSTATION, TrainCharacteristicsEnum.WAGONTYPE);
        types = EnumSet.range(TrainCharacteristicsEnum.PASSENGER, TrainCharacteristicsEnum.HOPPER);
    }

    public Set<Train> getTrains() {
        return trains;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if (!(localName.equalsIgnoreCase(TrainCharacteristicsEnum.RAILWAYSTATION.getValue()))) {

            if (TrainCharacteristicsEnum.PASSENGER.getValue().equalsIgnoreCase(localName)) {
                current = new PassengerTrain();

            } else if (TrainCharacteristicsEnum.FREIGHT.getValue().equalsIgnoreCase(localName)) {
                current = new FreightTrain();

            } else if (TrainCharacteristicsEnum.HIGHSPEED.getValue().equalsIgnoreCase(localName)) {
                current = new HighSpeedTrain();

            } else if (TrainCharacteristicsEnum.HOPPER.getValue().equalsIgnoreCase(localName)) {
                current = new Hopper();

            } else {
                TrainCharacteristicsEnum type = TrainCharacteristicsEnum.valueOf(localName.toUpperCase());

                if (fields.contains(type)) {
                    currentEnum = type;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (types.contains(TrainCharacteristicsEnum.valueOf(localName.toUpperCase()))) {
            trains.add(current);
            LOGGER.info("Train was added : " + current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        String s = new String(ch, start, length).trim();

        LOGGER.info("Current enum = " + currentEnum);
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    try {
                        current.setName(s);
                    } catch (IllegalTrainNameException e) {
                        LOGGER.error("Illegal train name " + e);
                    }
                    break;
                case MAXSPEED:
                    try {
                        current.setMaxSpeed(Integer.valueOf(s));
                    } catch (IllegalTrainMaxSpeedException e) {
                        LOGGER.error("Illegal train speed " + e);
                    }
                    break;
                case WAGONNUMBER:
                    try {
                        current.setWagonNumber(Integer.valueOf(s));
                    } catch (IllegalTrainWagonNumberException e) {
                        LOGGER.error("Illegal train wagon number " + e);
                    }
                    break;
                case TRAINTYPE:
                    try {
                        current.setTrainType(Train.TrainType.valueOf(s));
                    } catch (IllegalTrainTypeException e) {
                        LOGGER.error("Illegal train type " + e);
                    }
                    break;
                default:

                    if (current.getClass() == PassengerTrain.class) {

                        PassengerTrain passengerTrain = (PassengerTrain) current;

                        try {
                            passengerTrain.setPassengerValue(Integer.valueOf(s));
                        } catch (IllegalPassengerTrainValueException e) {
                            LOGGER.error("Illegal passenger value " + e);
                        }

                    } else if (current.getClass() == FreightTrain.class) {

                        FreightTrain freightTrain = (FreightTrain) current;

                        try {
                            freightTrain.setFreightValue(Integer.valueOf(s));
                        } catch (IllegalFreightTrainValueException e) {
                            LOGGER.error("Illegal freight value " + e);
                        }

                    } else if (current.getClass() == HighSpeedTrain.class) {

                        HighSpeedTrain highSpeedTrain = (HighSpeedTrain) current;

                        if (currentEnum == TrainCharacteristicsEnum.PASSENGERVALUE) {
                            try {
                                highSpeedTrain.setPassengerValue(Integer.parseInt(s));
                            } catch (IllegalPassengerTrainValueException e) {
                                LOGGER.error("Illegal passenger value " + e);
                            }

                        } else if (currentEnum == TrainCharacteristicsEnum.WAGONTYPE) {
                            try {
                                highSpeedTrain.setWagonType(HighSpeedTrain.WagonType.valueOf(s));
                            } catch (IllegalHighSpeedTrainWagonTypeTypeException e) {
                                LOGGER.error("Illegal wagon type " + e);
                            }
                        }

                    } else if (current.getClass() == Hopper.class) {

                        Hopper hopper = (Hopper) current;

                        if (currentEnum == TrainCharacteristicsEnum.FREIGHTVALUE) {
                            try {
                                hopper.setFreightValue(Integer.parseInt(s));
                            } catch (IllegalFreightTrainValueException e) {
                                LOGGER.error("Illegal freight value " + e);
                            }

                        } else if (currentEnum == TrainCharacteristicsEnum.MATERIAL) {
                            try {
                                hopper.setMaterial(Hopper.Material.valueOf(s));
                            } catch (IllegalHopperMaterialTypeException e) {
                                LOGGER.error("Illegal material type " + e);
                            }
                        }
                    }
                    break;
            }
        }
        currentEnum = null;
    }
}
