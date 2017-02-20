package service;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by User on 20.02.2017.
 */
public class CoffeErrorHandler extends DefaultHandler{

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println(getLineAddress(e) + " warnig!");
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println(getLineAddress(e) + " error!");
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println(getLineAddress(e) + " fatal!");
    }

    private String getLineAddress(SAXParseException e){
        return  e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
