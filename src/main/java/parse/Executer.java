package parse;

import entity.AbstractCoffe;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import service.CoffeValidator;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 20.02.2017.
 */
public class Executer {


  public Executer(){

  }
    public void parserSaxSecond(){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
        SAXParserImpl saxParser = new SAXParserImpl();
            parser.parse(new File(CoffeValidator.FILE_NAME) ,saxParser);
            ArrayList<AbstractCoffe> list = saxParser.getAbstractCoffes();
            System.out.println(list.size());
            for (AbstractCoffe arabicaCoffee : list){
                System.out.println(arabicaCoffee);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saxParser(){
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXCoffeParser handler = new SAXCoffeParser();
            reader.setContentHandler(handler);
            reader.parse(CoffeValidator.FILE_NAME);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
