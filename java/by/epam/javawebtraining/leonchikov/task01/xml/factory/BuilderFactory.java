package by.epam.javawebtraining.leonchikov.task01.xml.parserFactory;

import by.epam.javawebtraining.leonchikov.task01.xml.dom.TrainDOMBuilder;
import by.epam.javawebtraining.leonchikov.task01.xml.sax.TrainSaXBuilder;
import by.epam.javawebtraining.leonchikov.task01.xml.stAx.TrainStAxBuilder;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class BuilderFactory {

    public enum BuilderType {
        DOM, SAX, STAX
    }

    public AbstractBuilder createBuilder(BuilderType builderType) {

        AbstractBuilder builder = null;

        switch (builderType) {
            case SAX:
                builder = TrainSaXBuilder.getInstance();
                break;
            case STAX:
                builder = TrainStAxBuilder.getInstance();
                break;
            case DOM:
                builder = TrainDOMBuilder.getInstance();
                break;
            default:
                throw new EnumConstantNotPresentException(builderType.getDeclaringClass(), builderType.name());
        }
        return builder;
    }
}
