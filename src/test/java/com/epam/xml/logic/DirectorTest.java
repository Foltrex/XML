package com.epam.xml.logic;

import com.epam.xml.entity.HeartMedicine;
import com.epam.xml.entity.Medicine;
import com.epam.xml.entity.VascularMedicine;
import com.epam.xml.exception.MedicineException;
import com.epam.xml.factory.ParserType;
import com.epam.xml.parser.MedicineParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {
    private static final String XML_PATH = "src/test/resources/medicins.xml";
    private static final String XSD_PATH = "src/test/resources/medicationsSchema.xsd";
    private static final ParserType PARSER_TYPE = ParserType.DOM;

    @Test
    public void testParseShouldCreateWhenIsValid() throws MedicineException {
        // given
        MedicineXmlValidator medicineXmlValidator = Mockito.mock(MedicineXmlValidator.class);
        Mockito.when(medicineXmlValidator.isValid(XML_PATH, XSD_PATH)).thenReturn(true);
        Director director = new Director(medicineXmlValidator);

        // when
        List<Medicine> medicins = director.parse(XML_PATH, XSD_PATH, PARSER_TYPE);

        // then
        Assert.assertEquals(2, medicins.size());
        Mockito.verify(medicineXmlValidator, Mockito.times(1)).isValid(XML_PATH, XSD_PATH);
        Mockito.verifyNoMoreInteractions(medicineXmlValidator);
    }
}
