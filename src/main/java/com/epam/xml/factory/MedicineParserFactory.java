package com.epam.xml.factory;

import com.epam.xml.parser.MedicineDomParser;
import com.epam.xml.parser.MedicineJaxbParser;
import com.epam.xml.parser.MedicineParser;
import com.epam.xml.parser.MedicineSaxParser;
import org.apache.log4j.Logger;

public class MedicineParserFactory {
    private static final Logger LOGGER = Logger.getLogger(MedicineParserFactory.class);

    private MedicineParserFactory() {}

    public static MedicineParser create(ParserType type) {

        switch (type) {
            case SAX:
                LOGGER.info("Creating SAX parser");
                return new MedicineSaxParser();
            case DOM:
                LOGGER.info("Creating DOM parser");
                return new MedicineDomParser();
            case JAXB:
                LOGGER.info("Creating JAXB parser");
                return new MedicineJaxbParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
