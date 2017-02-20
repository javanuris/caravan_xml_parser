package parse;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import service.CoffeValidator;

import java.io.IOException;

/**
 * Created by User on 20.02.2017.
 */
public class Executer {


  public Executer(){

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
