package parse;

import entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import service.Utils;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class SaxCoffeeParser extends DefaultHandler implements AbstractCoffeeParser {
    private ArrayList<AbstractCoffe> abstractCoffes = new ArrayList<AbstractCoffe>();
    private AbstractCoffe abstractCoffe = null;
    private boolean coofeType = false;
    private boolean coffeSort = false;
    private boolean coffeePrice = false;
    private boolean coffeeWieght = false;

    @Override
    public void buildSetCoffee(String str) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            try {
                parser.parse(str, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase(ArabicaCoffee.class.getSimpleName())) {
            abstractCoffe = new ArabicaCoffee();
        }
        if (qName.equalsIgnoreCase(DewevreiCoffe.class.getSimpleName())) {
            abstractCoffe = new DewevreiCoffe();
        }
        if (qName.equalsIgnoreCase(CanephoraCoffe.class.getSimpleName())) {
            abstractCoffe = new CanephoraCoffe();
        }
        if (qName.equalsIgnoreCase(LibericaCoffe.class.getSimpleName())) {
            abstractCoffe = new LibericaCoffe();
        }
        if (qName.equalsIgnoreCase(Utils.COFFEE_TYPE)) {
            coofeType = true;
        }
        if (qName.equalsIgnoreCase(Utils.COFFEE_SORT)) {
            coffeSort = true;
        }
        if (qName.equalsIgnoreCase(Utils.COFFEE_PRICE)) {
            coffeePrice = true;
        }
        if (qName.equalsIgnoreCase(Utils.COFFEE_WEIGHT)) {
            coffeeWieght = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (coofeType) {
            abstractCoffe.setCoffeeType(new String(ch, start, length));
            coofeType = false;
        }
        if (coffeSort) {
            abstractCoffe.setCoffeeSort(new String(ch, start, length));
            coffeSort = false;
        }
        if (coffeePrice) {
            abstractCoffe.setPrice(Integer.parseInt(new String(ch, start, length)));
            coffeePrice = false;
        }
        if (coffeeWieght) {
            abstractCoffe.setWeight(Integer.parseInt(new String(ch, start, length)));
            coffeeWieght = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase(ArabicaCoffee.class.getSimpleName())
                || qName.equalsIgnoreCase(DewevreiCoffe.class.getSimpleName())
                || qName.equalsIgnoreCase(LibericaCoffe.class.getSimpleName())
                || qName.equalsIgnoreCase(CanephoraCoffe.class.getSimpleName())) {
            abstractCoffes.add(abstractCoffe);
        }
    }

    public ArrayList<AbstractCoffe> getListOfCoffee() {
        return abstractCoffes;
    }


}
