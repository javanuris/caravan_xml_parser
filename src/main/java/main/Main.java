package main;

import parse.Executer;
import service.CoffeValidator;

/**
 * Created by User on 20.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        new CoffeValidator().validateXMLviaXDS();
        new Executer().parserSaxSecond();


    }
}
