package main;
import entity.AbstractCoffe;
import parse.*;
import service.Utils;
import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class ParseHolder {
    private CoffeeBuilderFactory coffeeBuilder = new CoffeeBuilderFactory();
    public ArrayList<AbstractCoffe> parseXML(String parsingType) {
        ArrayList<AbstractCoffe> list = null;
        AbstractCoffeeParser bulder = coffeeBuilder.createCoffeeBuilder(parsingType);
        bulder.buildSetCoffee(Utils.FILE_NAME);
        list = bulder.getListOfCoffee();
        return list;
    }
}
