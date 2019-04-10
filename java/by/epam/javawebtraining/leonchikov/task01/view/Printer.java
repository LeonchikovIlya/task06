package by.epam.javawebtraining.leonchikov.task01.view;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Printer {

    public enum Type {
        FILE, CONSOLE
    }

    public static Printable createPrinter(Type type) {

        Printable printable = new ConsolePrinter();

        switch (type) {
            case FILE:
                printable = new FilePrinter();
                break;
            case CONSOLE:
                printable = new ConsolePrinter();
                break;
        }
        return printable;
    }
}
