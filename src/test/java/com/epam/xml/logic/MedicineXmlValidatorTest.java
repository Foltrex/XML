package com.epam.xml.logic;

import com.epam.xml.exception.MedicineException;
import com.epam.xml.logic.MedicineXmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class MedicineXmlValidatorTest {

    private static final String VALID_XML = "src/test/resources/medicins.xml";
    private static final String VALID_XSD = "src/test/resources/medicationsSchema.xsd";
    private static final String INVALID_XML = "src/test/resources/invalidMedicins.xml";
    private static final String EMPTY_PATH = "";

    @Test
    public void testIsValidShouldReturnTrueWhenFileIsValid() throws MedicineException {
        //given
        MedicineXmlValidator validator = new MedicineXmlValidator();

        //when
        boolean actual = validator.isValid(VALID_XML, VALID_XSD);

        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenFileIsNotValid() throws MedicineException {
        //given
        MedicineXmlValidator validator = new MedicineXmlValidator();

        //when
        boolean actual = validator.isValid(INVALID_XML, VALID_XSD);

        //then
        Assert.assertFalse(actual);
    }

    //then
    @Test(expected = MedicineException.class)
    public void testIsValidShouldThrowExceptionWhenPathIsNull() throws MedicineException {
        //given
        MedicineXmlValidator validator = new MedicineXmlValidator();

        //when
        boolean actual = validator.isValid(null, null);
    }

    //then
    @Test(expected = MedicineException.class)
    public void testIsValidShouldThrowExceptionWhenPathIsEmpty() throws MedicineException {
        //given
        MedicineXmlValidator validator = new MedicineXmlValidator();

        //when
        boolean actual = validator.isValid(EMPTY_PATH, EMPTY_PATH);
    }

}
