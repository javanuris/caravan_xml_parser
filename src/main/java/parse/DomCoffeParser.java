package parse;

import entity.AbstractCoffe;
import entity.ArabicaCoffee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 21.02.2017.
 */
public class DomCoffeParser {
private DocumentBuilder documentBuilder;
    ArrayList<AbstractCoffe> abstractCoffes;
    public DomCoffeParser(){
        this.abstractCoffes = new ArrayList<AbstractCoffe>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void buildSetCoffe(String fileName){

        Document doc = null;
        try {
            doc = documentBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList coffeeList = root.getElementsByTagName("arabicacoffee");
            System.out.println(coffeeList.getLength()+ "<---");
            for(int i = 0; i < coffeeList.getLength(); i++){
                Element coffeElement = (Element)coffeeList.item(i);
                AbstractCoffe abstractCoffe = buildStudent(coffeElement ,new ArabicaCoffee());
                abstractCoffes.add(abstractCoffe);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private AbstractCoffe buildStudent(Element cofffeElement , AbstractCoffe abstractCoffe){
        AbstractCoffe coffeObject = abstractCoffe;
        coffeObject.setCoffeeType(getElementTextContent(cofffeElement , "coffetype"));
        coffeObject.setCoffeeSort(getElementTextContent(cofffeElement , "coffesort"));
        return coffeObject;
    }

    private static String getElementTextContent(Element element, String elemntName){
        NodeList nodeList = element.getElementsByTagName(elemntName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }


    public ArrayList<AbstractCoffe> getAbstractCoffes() {
        return abstractCoffes;
    }
}
