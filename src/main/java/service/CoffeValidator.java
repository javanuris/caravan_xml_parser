package service;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 20.02.2017.
 */
public class CoffeValidator {

    private Schema schema = null;
    private String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private SchemaFactory factory = SchemaFactory.newInstance(language);
    public void validateXMLviaXDS() {
        try {
            schema = factory.newSchema(new File(Utils.SCHEMA_NAME));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(Utils.FILE_NAME, new CoffeErrorHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
