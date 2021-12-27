package com.epam.xml.parser;

import com.epam.xml.entity.Medicine;
import com.epam.xml.exception.MedicineException;
import com.epam.xml.logic.MedicineHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class MedicineSaxParser implements MedicineParser {
    private final MedicineHandler medicineHandler = new MedicineHandler();

    @Override
    public List<Medicine> parse(String xmlPath) throws MedicineException {
        SAXParserFactory saxParserFactory =SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(medicineHandler);
            xmlReader.parse(xmlPath);
        } catch (IOException | SAXException | ParserConfigurationException exception) {
            throw new MedicineException("Sax parsing exception: ", exception);
        }

        return medicineHandler.getMedicins();
    }
}
