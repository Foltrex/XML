package com.epam.xml.factory;

import com.epam.xml.parser.MedicineDomParser;
import com.epam.xml.parser.MedicineJaxbParser;
import com.epam.xml.parser.MedicineParser;
import com.epam.xml.parser.MedicineSaxParser;

public class MedicineParserFactory {

    private MedicineParserFactory() {}

    public static MedicineParser create(ParserType type) {

        switch (type) {
            case SAX:
                return new MedicineSaxParser();
            case DOM:
                return new MedicineDomParser();
            case JAXB:
                return new MedicineJaxbParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
