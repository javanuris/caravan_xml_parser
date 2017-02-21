package main;

import entity.AbstractCoffe;
import service.CoffeValidator;
import service.EqualityCompresion;
import ui.Shower;

import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class Main {

    public static void main(String[] args) {
       ArrayList<AbstractCoffe> listDom = new Execute().parseDom();
        ArrayList<AbstractCoffe> listSax =  new Execute().parserSax();
        ArrayList<AbstractCoffe> listStaX = new Execute().parserStAX();
        new CoffeValidator().validateXMLviaXDS();
        new Shower().showPopulateObjects(listDom , "DOM");
        new Shower().showPopulateObjects(listSax , "SAX");
        new Shower().showPopulateObjects(listStaX , "StAX");
        EqualityCompresion equalityCompresion = new EqualityCompresion();
        System.out.println(equalityCompresion.equality(listStaX , listSax) + " <-- Сравние двух списков с обьектами ");

    }
}
