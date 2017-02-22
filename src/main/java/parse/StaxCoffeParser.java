package parse;

import entity.*;
import service.Utils;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by User on 21.02.2017.
 */
public class StaxCoffeParser implements AbstractCoffeeParser{
    private ArrayList<AbstractCoffe> abstractCoffes = new ArrayList<AbstractCoffe>();
    private AbstractCoffe abstractCoffe = null;

    private boolean coofeType = false;
    private boolean coffeSort = false;
    private boolean coffeePrice = false;
    private boolean coffeeWieght = false;

    public void buildSetCoffee (String fileName) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(fileName));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        startElement(event);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        middleElement(event);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        endElement(event);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        String qName = startElement.getName().getLocalPart();
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

    public void middleElement(XMLEvent event) {
        Characters characters = event.asCharacters();
        if (coofeType) {
            abstractCoffe.setCoffeeType(characters.getData());
            coofeType = false;
        }
        if (coffeSort) {
            abstractCoffe.setCoffeeSort(characters.getData());
            coffeSort = false;
        }
        if (coffeePrice) {
            abstractCoffe.setPrice(Integer.parseInt(characters.getData()));
            coffeePrice = false;
        }
        if (coffeeWieght) {
            abstractCoffe.setWeight(Integer.parseInt(characters.getData()));
            coffeeWieght = false;
        }
    }

    public void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        if (endElement.getName().getLocalPart().equalsIgnoreCase(ArabicaCoffee.class.getSimpleName())
                || endElement.getName().getLocalPart().equalsIgnoreCase(DewevreiCoffe.class.getSimpleName())
                || endElement.getName().getLocalPart().equalsIgnoreCase(LibericaCoffe.class.getSimpleName())
                || endElement.getName().getLocalPart().equalsIgnoreCase(CanephoraCoffe.class.getSimpleName())) {
            abstractCoffes.add(abstractCoffe);
        }
    }

    public ArrayList<AbstractCoffe> getListOfCoffee() {
        return abstractCoffes;
    }

}
