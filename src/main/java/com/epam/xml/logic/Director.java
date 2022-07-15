package com.epam.xml.logic;

import com.epam.xml.entity.Medicine;
import com.epam.xml.exception.MedicineException;
import com.epam.xml.factory.MedicineParserFactory;
import com.epam.xml.factory.ParserType;
import com.epam.xml.parser.MedicineParser;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private MedicineXmlValidator xmlValidator;

    public Director(MedicineXmlValidator xmlValidator) {
        this.xmlValidator = xmlValidator;
    }

    public List<Medicine> parse(String xmlPath, String xsdPath, ParserType parserType) {
        List<Medicine> medicins = new ArrayList<>();

        try {
            if (xmlValidator.isValid(xmlPath, xsdPath)) {
                MedicineParser parser = MedicineParserFactory.create(parserType);
                medicins = parser.parse(xmlPath);
            }
        } catch (MedicineException exception) {
            LOGGER.warn("Error creating medicins: ", exception);
        }

        return medicins;
    }
}
