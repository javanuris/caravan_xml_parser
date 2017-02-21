package main;

import entity.AbstractCoffe;
import org.xml.sax.SAXException;
import parse.DomCoffeParser;
import parse.SaxCoffeParser;
import service.Utils;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class Execute {

    public ArrayList<AbstractCoffe> parseDom() {
        ArrayList<AbstractCoffe> list = null;
        DomCoffeParser domCoffeParser = new DomCoffeParser();
        domCoffeParser.buildSetCoffe(Utils.FILE_NAME);
        list = domCoffeParser.getAbstractCoffes();
        return list;
    }

    public ArrayList<AbstractCoffe> parserSax() {
        ArrayList<AbstractCoffe> list = null;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            SaxCoffeParser saxParser = new SaxCoffeParser();
            parser.parse(new File(Utils.FILE_NAME), saxParser);
            list = saxParser.getAbstractCoffes();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
