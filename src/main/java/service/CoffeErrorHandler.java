package service;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by User on 20.02.2017.
 */
public class CoffeErrorHandler extends DefaultHandler {
    private static final String WORNING = " warning!";
    private static final String ERROR = " error!";
    private static final String FATAL = " fatal!";

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println(getLineAddress(e) + WORNING);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println(getLineAddress(e) + ERROR);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println(getLineAddress(e) + FATAL);
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
