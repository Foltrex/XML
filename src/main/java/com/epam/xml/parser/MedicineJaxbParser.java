package com.epam.xml.parser;

import com.epam.xml.entity.Medicine;
import com.epam.xml.entity.Medicins;
import com.epam.xml.exception.MedicineException;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MedicineJaxbParser implements MedicineParser {
    private static final Logger LOGGER = Logger.getLogger(MedicineJaxbParser.class);

    @Override
    public List<Medicine> parse(String xmlPath) throws MedicineException {
        List<Medicine> medicineList;

        try {
            JAXBContext context = JAXBContext.newInstance(Medicins.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader(xmlPath);
            Medicins medicins = (Medicins) unmarshaller.unmarshal(reader);

            medicineList = medicins.getMedicins();
            LOGGER.info("Medicins were added to medicine list");

        } catch (JAXBException | FileNotFoundException exception) {
            throw new MedicineException("Jaxb parsing exception: ", exception);
        }

        return medicineList;
    }
}
