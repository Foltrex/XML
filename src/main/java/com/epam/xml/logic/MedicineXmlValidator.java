package com.epam.xml.logic;

import com.epam.xml.exception.MedicineException;

public class MedicineXmlValidator {
    public boolean isValid(String xmlPath, String xsdPath) throws MedicineException {
        if (xmlPath == null || xmlPath.isEmpty() || xsdPath == null || xsdPath.isEmpty()) {
            throw new MedicineException("Xml path or Xsd path is empty");
        }
        return false;
        // TODO: sdlkfj
    }
}
