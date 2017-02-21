package parse;

import entity.AbstractCoffe;

import java.util.ArrayList;

/**
 * Created by User on 21.02.2017.
 */
public interface AbstractCoffeeParser {
    void  buildSetCoffee(String str);
    ArrayList<AbstractCoffe> getListOfCoffee();
}
