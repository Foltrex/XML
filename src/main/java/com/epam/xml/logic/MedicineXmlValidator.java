package com.epam.xml.logic;

import com.epam.xml.exception.MedicineException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class MedicineXmlValidator {
    public boolean isValid(String xmlPath, String xsdPath) throws MedicineException {
        if (xmlPath == null || xmlPath.isEmpty() || xsdPath == null || xsdPath.isEmpty()) {
            throw new MedicineException("Xml path or Xsd path is empty");
        }

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        boolean isValid = true;

        try {
            File xsdFile = new File(xsdPath);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Source source = new StreamSource(xmlPath);

            Validator validator = schema.newValidator();
            validator.validate(source);
        } catch (SAXException | IOException exception) {
            isValid = false;
        }

        return isValid;
    }
}
