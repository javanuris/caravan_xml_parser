package parse;

import entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class SAXParserImpl extends DefaultHandler{
    private ArrayList<AbstractCoffe> abstractCoffes = new ArrayList<AbstractCoffe>();
    private AbstractCoffe abstractCoffe = null;


    boolean coffeType = false;
    boolean coffeeSort = false;
    boolean coffePrice =false;
    boolean coffeeWeight =false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            collectValue(qName , ArabicaCoffee.class, attributes);

    }

    public void collectValue( String qName ,Class clazz, Attributes attributes){
        if(qName.equalsIgnoreCase(clazz.getSimpleName())) {
            String str = attributes.getValue("id");
            abstractCoffe = new ArabicaCoffee();
            abstractCoffe.setId(Integer.parseInt(str));
        }
        else if(qName.equalsIgnoreCase("coffetype")){
            coffeType = true;
        }
        else if(qName.equalsIgnoreCase("coffesort")){
            coffeeSort = true;
        }
        else if(qName.equalsIgnoreCase("coffeprice")){
            coffePrice = true;
        }
        else if(qName.equalsIgnoreCase("coffeeweight")){
            coffeeWeight = true;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(coffeType){
         abstractCoffe.setCoffeeType(new String(ch, start , length));
            coffeType = false;
        }else if(coffeeSort){
            abstractCoffe.setCoffeeSort(new String(ch, start , length));
            coffeeSort = false;
        }else if(coffePrice){
            abstractCoffe.setPrice(Integer.parseInt(new String(ch, start , length)));
            coffePrice = false;
        }else if(coffeeWeight){
           // abstractCoffe.setWeight(Integer.parseInt(new String(ch, start , length)));
        }

    }  @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase(ArabicaCoffee.class.getSimpleName())){
            abstractCoffes.add(abstractCoffe);
          //  System.out.println(abstractCoffes.size());
           // System.out.println(abstractCoffes.get(0).getPrice());
        }

    }

    public ArrayList<AbstractCoffe> getAbstractCoffes() {
        return abstractCoffes;
    }
}
