package parse;

import entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import service.Utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 21.02.2017.
 */
public class DomCoffeeParser implements AbstractCoffeeParser{

    private DocumentBuilder documentBuilder;
    ArrayList<AbstractCoffe> abstractCoffes;


    public DomCoffeeParser() {
        System.out.println(AbstractCoffe.class.getSuperclass().getSimpleName());
        this.abstractCoffes = new ArrayList<AbstractCoffe>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void buildSetCoffee(String fileName) {
        Document doc = null;
        try {
            doc = documentBuilder.parse(fileName);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            for (int i = 0; i < Utils.KIND_OF_COFFEE.length; i++) {
                NodeList coffeeList = root.getElementsByTagName(Utils.KIND_OF_COFFEE[i]);
                for (int z = 0; z < coffeeList.getLength(); z++) {
                    Element coffeElement = (Element) coffeeList.item(z);
                    AbstractCoffe abstractCoffe = buildStudent(coffeElement);
                    abstractCoffes.add(abstractCoffe);
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AbstractCoffe buildStudent(Element coffeeElement) {
        AbstractCoffe coffeObject = null;
        if (ArabicaCoffee.class.getSimpleName().equalsIgnoreCase(coffeeElement.getTagName())) {
            coffeObject = new ArabicaCoffee();
        }
        if (DewevreiCoffe.class.getSimpleName().equalsIgnoreCase(coffeeElement.getTagName())) {
            coffeObject = new DewevreiCoffe();
        }
        if (LibericaCoffe.class.getSimpleName().equalsIgnoreCase(coffeeElement.getTagName())) {
            coffeObject = new LibericaCoffe();
        }
        if (CanephoraCoffe.class.getSimpleName().equalsIgnoreCase(coffeeElement.getTagName())) {
            coffeObject = new CanephoraCoffe();
        }
        coffeObject.setCoffeeType(getElementTextContent(coffeeElement, Utils.COFFEE_TYPE));
        coffeObject.setCoffeeSort(getElementTextContent(coffeeElement, Utils.COFFEE_SORT));
        coffeObject.setPrice(Integer.parseInt(getElementTextContent(coffeeElement, Utils.COFFEE_PRICE)));
        coffeObject.setWeight(Integer.parseInt(getElementTextContent(coffeeElement, Utils.COFFEE_WEIGHT)));
        return coffeObject;
    }

    private static String getElementTextContent(Element element, String elemntName) {
        NodeList nodeList = element.getElementsByTagName(elemntName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }

    public ArrayList<AbstractCoffe> getListOfCoffee() {
        return abstractCoffes;
    }


}
