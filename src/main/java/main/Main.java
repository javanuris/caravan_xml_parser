package main;

import entity.AbstractCoffe;
import service.CoffeValidator;
import service.EqualityComparte;
import service.Utils;
import ui.Shower;

import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class Main {

    public static void main(String[] args) {
       ArrayList<AbstractCoffe> listDom = new ParseHolder().parseXML(Utils.DOM);
        ArrayList<AbstractCoffe> listSax =  new ParseHolder().parseXML(Utils.SAX);
        ArrayList<AbstractCoffe> listStaX = new ParseHolder().parseXML(Utils.STAX);

        new CoffeValidator().validateXMLviaXDS();

        new Shower().showPopulateObjects(listDom , Utils.DOM);
        new Shower().showPopulateObjects(listSax , Utils.SAX);
        new Shower().showPopulateObjects(listStaX , Utils.STAX);

        EqualityComparte equalityCompresion = new EqualityComparte();

        System.out.println(equalityCompresion.equality(listStaX , listSax) + " <-- Сравние двух списков с обьектами ");

    }
}
