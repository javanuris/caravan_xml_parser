package main;

import entity.AbstractCoffe;
import org.xml.sax.SAXException;
import parse.DomCoffeParser;
import parse.SaxCoffeParser;
import service.CoffeValidator;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class Executer {

    public void parseDom(){
        DomCoffeParser domCoffeParser = new DomCoffeParser();
        domCoffeParser.buildSetCoffe(CoffeValidator.FILE_NAME);
        ArrayList<AbstractCoffe> list = domCoffeParser.getAbstractCoffes();
        for(AbstractCoffe abstractCoffe : list)
        System.out.println(abstractCoffe);
    }

    public void parserSax() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            SaxCoffeParser saxParser = new SaxCoffeParser();
            parser.parse(new File(CoffeValidator.FILE_NAME), saxParser);
            ArrayList<AbstractCoffe> list = saxParser.getAbstractCoffes();
            for (AbstractCoffe arabicaCoffee : list) {
                System.out.println(arabicaCoffee);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
