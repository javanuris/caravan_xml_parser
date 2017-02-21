package parse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * Created by User on 20.02.2017.
 */
public class SAXCoffeParser extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String s = localName;
        System.out.println(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch , start , length) );
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print(localName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nParsting ended");
    }
}
