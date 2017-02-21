package parse;

import entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class SAXParserImpl extends DefaultHandler {
    private ArrayList<AbstractCoffe> abstractCoffes = new ArrayList<AbstractCoffe>();
    private AbstractCoffe abstractCoffe = null;

    boolean coofeType = false;
    boolean coffeSort = false;
    boolean coffeePrice =false;
    boolean coffeeWieght = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало докумена");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
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
        if(qName.equalsIgnoreCase("coffetype")){
            coofeType = true;
        }
        if(qName.equalsIgnoreCase("coffesort")){
            coffeSort = true;
        }
        if(qName.equalsIgnoreCase("coffeprice")){
            coffeePrice = true;
        }
        if(qName.equalsIgnoreCase("coffeeweight")){
            coffeeWieght = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(coofeType){
            abstractCoffe.setCoffeeType(new String(ch , start , length));
            coofeType =false;
        }
        if(coffeSort){
            abstractCoffe.setCoffeeSort(new String(ch , start , length));
            coffeSort =false;
        }
        if(coffeePrice){
            abstractCoffe.setPrice(Integer.parseInt(new String(ch , start , length)));
            coffeePrice =false;
        }
        if(coffeeWieght){
            abstractCoffe.setWeight(Integer.parseInt(new String(ch , start , length)));
            coffeeWieght =false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(ArabicaCoffee.class.getSimpleName())
                || qName.equalsIgnoreCase(DewevreiCoffe.class.getSimpleName())
                || qName.equalsIgnoreCase(LibericaCoffe.class.getSimpleName())
                || qName.equalsIgnoreCase(CanephoraCoffe.class.getSimpleName())) {
            abstractCoffes.add(abstractCoffe);
        }
    }


    public ArrayList<AbstractCoffe> getAbstractCoffes() {
        return abstractCoffes;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец документа");
    }
}
