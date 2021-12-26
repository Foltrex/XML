package com.epam.xml.parser;

import com.epam.xml.entity.Medicine;
import com.epam.xml.exception.MedicineException;

import java.util.List;

public interface MedicineParser {
    List<Medicine> parse(String xmlPath) throws MedicineException;
}
