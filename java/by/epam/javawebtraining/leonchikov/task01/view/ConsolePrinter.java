package by.epam.javawebtraining.leonchikov.task01.view;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class ConsolePrinter implements Printable {

    @Override
    public void print(Object obj) {
        System.out.println(obj);
    }

}
