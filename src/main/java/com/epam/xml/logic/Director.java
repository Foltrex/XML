package com.epam.xml.logic;

import com.epam.xml.entity.Medicine;
import com.epam.xml.exception.MedicineException;
import com.epam.xml.factory.MedicineParserFactory;
import com.epam.xml.factory.ParserType;
import com.epam.xml.parser.MedicineParser;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private static final MedicineXmlValidator xmlValidator = new MedicineXmlValidator();

    public List<Medicine> parse(String xmlPath, String xsdPath, ParserType parserType) {
        List<Medicine> medicines = new ArrayList<>();

        try {
            if (xmlValidator.isValid(xmlPath, xsdPath)) {
                MedicineParser parser = MedicineParserFactory.create(parserType);
                medicines = parser.parse(xmlPath);
            }
        } catch (MedicineException exception) {

        }

        return medicines;
    }
}
