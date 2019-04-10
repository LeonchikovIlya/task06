package by.epam.javawebtraining.leonchikov.task01.xml;

public enum TrainCharacteristicsEnum {

    PASSENGER("passenger"),FREIGHT("freight"),HIGHSPEED("highspeed")
    ,HOPPER("hopper"),RAILWAYSTATION("railwayStation"),NAME("name"),MAXSPEED("maxSpeed"),WAGONNUMBER("wagonNumber"),TRAINTYPE("trainType")
    ,PASSENGERVALUE("passengerValue"),FREIGHTVALUE("freightValue"),MATERIAL("material"),WAGONTYPE("wagonType");

    private String value;

    TrainCharacteristicsEnum(String string) {
        this.value = string;
    }

    public String getValue() {
        return value;
    }
}
