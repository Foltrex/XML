package com.epam.xml.parser;

import com.epam.xml.entity.*;
import com.epam.xml.entity.version.*;
import com.epam.xml.exception.MedicineException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MedicineDomParserTest {

    private static final String VALID_XML = "src/test/resources/medicins.xml";

    @Test
    public void testParseShouldParseWhenXmlIsValid() throws MedicineException {
        // given

        // First Medicine
        // --------------------------------------
        Versions versionsOfFirstMedicine = new Versions();

        Analogs analogsOfFirstMedicine = new Analogs();
        analogsOfFirstMedicine.add("concor");
        analogsOfFirstMedicine.add("bicard");

        Certificate certificateOfFirstVersionOfFirstMedicine = new Certificate();
        certificateOfFirstVersionOfFirstMedicine.setNumber("N83bs90vb32");
        certificateOfFirstVersionOfFirstMedicine.setIssueDate("2021-12-05");
        certificateOfFirstVersionOfFirstMedicine.setExpiryDate("2023-12-05");

        MedicinePackage medicinePackageOfFirstVersionOfFirstMedicine = new MedicinePackage(PackageType.CARDBOARD_BOX,
                28, 16);

        Dosage dosageOfFirstVersionOfFirstMedicine = new Dosage(5, 12);


        Version firstVersionOfFirstMedicine = new Version(VersionName.PILLS, "Lekpharm", certificateOfFirstVersionOfFirstMedicine,
                medicinePackageOfFirstVersionOfFirstMedicine, dosageOfFirstVersionOfFirstMedicine);

        versionsOfFirstMedicine.add(firstVersionOfFirstMedicine);

        Medicine medicineFirst = new HeartMedicine("medicine290", "bisoprolol",
                "beta-blocant", analogsOfFirstMedicine, versionsOfFirstMedicine);


        // Second Medicine
        // --------------------------------------

        Versions versionsOfSecondMedicine = new Versions();

        Analogs analogsOfSecondMedicine = new Analogs();
        analogsOfSecondMedicine.add("lucetam");
        analogsOfSecondMedicine.add("macsotropil");

        // First version of second medicine
        // -------------------------
        Certificate certificateOfFirstVersionOfSecondMedicine = new Certificate();
        certificateOfFirstVersionOfSecondMedicine.setNumber("bUI82kd5ti");
        certificateOfFirstVersionOfSecondMedicine.setIssueDate("2021-12-07");
        certificateOfFirstVersionOfSecondMedicine.setExpiryDate("2023-12-07");

        MedicinePackage medicinePackageOfFirstVersionOfSecondMedicine =
                new MedicinePackage(PackageType.BLISTER, 10, 7);

        Dosage dosageOfFirstVersionOfSecondMedicine = new Dosage(400, 6);

        Version firstVersionOfSecondMedicine = new Version(VersionName.CAPSULES, "Egis Pharmaceutical", certificateOfFirstVersionOfSecondMedicine,
                medicinePackageOfFirstVersionOfSecondMedicine, dosageOfFirstVersionOfSecondMedicine);


        versionsOfSecondMedicine.add(firstVersionOfSecondMedicine);


        // Second version of second medicine
        // -------------------------
        Certificate certificateOfSecondVersionOfSecondMedicine = new Certificate();
        certificateOfSecondVersionOfSecondMedicine.setNumber("T9nkjSn93");
        certificateOfSecondVersionOfSecondMedicine.setIssueDate("2021-11-17");
        certificateOfSecondVersionOfSecondMedicine.setExpiryDate("2023-11-17");

        MedicinePackage medicinePackageOfSecondVersionOfSecondMedicine = new MedicinePackage(PackageType.BOTTLE,
                120, 8);

        Dosage dosageOfSecondVersionOfSecondMedicine = new Dosage(2333, 6);


        Version secondVersionOfSecondMedicine = new Version(VersionName.SOLUTION, "Meness", certificateOfSecondVersionOfSecondMedicine,
                medicinePackageOfSecondVersionOfSecondMedicine, dosageOfSecondVersionOfSecondMedicine);

        versionsOfSecondMedicine.add(secondVersionOfSecondMedicine);


        // Third version of second medicine
        // -------------------------
        Certificate certificateOfThirdVersionOfSecondMedicine = new Certificate();
        certificateOfThirdVersionOfSecondMedicine.setNumber("BI1bksJHI");
        certificateOfThirdVersionOfSecondMedicine.setIssueDate("2021-10-27");
        certificateOfThirdVersionOfSecondMedicine.setExpiryDate("2023-10-27");

        MedicinePackage medicinePackageOfThirdVersionOfSecondMedicine = new MedicinePackage(PackageType.CARDBOARD_BOX,
                10, 10);

        Dosage dosageOfThirdVersionOfSecondMedicine = new Dosage(200, 6);


        Version thirdVersionOfSecondMedicine = new Version(VersionName.PILLS, "TOGOS", certificateOfThirdVersionOfSecondMedicine,
                medicinePackageOfThirdVersionOfSecondMedicine, dosageOfThirdVersionOfSecondMedicine);

        versionsOfSecondMedicine.add(thirdVersionOfSecondMedicine);

        Medicine medicineSecond = new VascularMedicine("medicine902", "piracetam", "nootropics",
                analogsOfSecondMedicine, versionsOfSecondMedicine);

        // --------------------------------------

        MedicineParser medicineParser = new MedicineDomParser();
        List<Medicine> expected = Arrays.asList(medicineFirst, medicineSecond);

        //when
        List<Medicine> actual = medicineParser.parse(VALID_XML);

        //then
        Assert.assertEquals(expected, actual);

    }

}
