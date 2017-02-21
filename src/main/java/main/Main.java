package main;

import entity.AbstractCoffe;
import service.CoffeValidator;
import ui.Shower;

import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        new CoffeValidator().validateXMLviaXDS();
        new Shower().showPopulateObjects(new Execute().parseDom() , "DOM");
        new Shower().showPopulateObjects(new Execute().parserSax() , "SAX");

    }
}
