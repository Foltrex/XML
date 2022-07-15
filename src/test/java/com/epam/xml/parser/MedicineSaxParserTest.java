package com.epam.xml.parser;

import com.epam.xml.entity.*;
import com.epam.xml.entity.version.*;
import com.epam.xml.exception.MedicineException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MedicineSaxParserTest {

    private static final String VALID_XML = "src/test/resources/medicins.xml";

    @Test
    public void testParseShouldParseWhenXmlIsValid() throws MedicineException {
        // given
        Medicine heartMedicine = createHeartMedicine();
        Medicine vascularMedicine = createVascularMedicine();

        MedicineParser medicineParser = new MedicineSaxParser();
        List<Medicine> expected = Arrays.asList(heartMedicine, vascularMedicine);

        //when
        List<Medicine> actual = medicineParser.parse(VALID_XML);

        //then
        Assert.assertEquals(expected, actual);
    }



    private HeartMedicine createHeartMedicine() {
        Versions versionsOfFirstMedicine = createVersionsOfHeartMedicine();
        Analogs analogsOfFirstMedicine = createAnalogsOfHeartMedicine();

        return new HeartMedicine("medicine290", "bisoprolol", "beta-blocant", analogsOfFirstMedicine, versionsOfFirstMedicine);
    }

    private VascularMedicine createVascularMedicine() {

        Versions versionsOfSecondMedicine = createVersionsOfVascularMedicine();
        Analogs analogsOfSecondMedicine = createAnalogsOfVascularMedicine();

        return new VascularMedicine("medicine902", "piracetam", "nootropics", analogsOfSecondMedicine, versionsOfSecondMedicine);
    }



    private Analogs createAnalogsOfHeartMedicine() {
        Analogs analogsOfHeartMedicine = new Analogs();
        analogsOfHeartMedicine.add("concor");
        analogsOfHeartMedicine.add("bicard");
        return analogsOfHeartMedicine;
    }

    private Versions createVersionsOfHeartMedicine() {
        Versions versionsOfHeartMedicine = new Versions();
        Version firstVersionOfHeartMedicine = createFirstVersionOfHeartMedicine();
        versionsOfHeartMedicine.add(firstVersionOfHeartMedicine);
        return versionsOfHeartMedicine;
    }

    private Version createFirstVersionOfHeartMedicine() {
        Certificate certificateOfFirstVersionOfFirstMedicine = new Certificate();
        certificateOfFirstVersionOfFirstMedicine.setNumber("N83bs90vb32");
        certificateOfFirstVersionOfFirstMedicine.setIssueDate("2021-12-05");
        certificateOfFirstVersionOfFirstMedicine.setExpiryDate("2023-12-05");

        MedicinePackage medicinePackageOfFirstVersionOfFirstMedicine = new MedicinePackage(PackageType.CARDBOARD_BOX,
                28, 16);

        Dosage dosageOfFirstVersionOfFirstMedicine = new Dosage(5, 12);

        return new Version(VersionName.PILLS, "Lekpharm", certificateOfFirstVersionOfFirstMedicine,
                medicinePackageOfFirstVersionOfFirstMedicine, dosageOfFirstVersionOfFirstMedicine);
    }



    private Versions createVersionsOfVascularMedicine() {
        Versions versionsOfVascularMedicine = new Versions();
        Version firstVersionOfVascularMedicine = createFirstVersionOfVascularMedicine();
        Version secondVersionOfVascularMedicine = createSecondVersionOfVascularMedicine();
        Version thirdVersionOfVascularMedicine = createThirdVersionOfVascularMedicine();

        versionsOfVascularMedicine.add(firstVersionOfVascularMedicine);
        versionsOfVascularMedicine.add(secondVersionOfVascularMedicine);
        versionsOfVascularMedicine.add(thirdVersionOfVascularMedicine);

        return versionsOfVascularMedicine;
    }

    private Version createFirstVersionOfVascularMedicine() {
        Certificate certificateOfFirstVersionOfSecondMedicine = new Certificate();
        certificateOfFirstVersionOfSecondMedicine.setNumber("bUI82kd5ti");
        certificateOfFirstVersionOfSecondMedicine.setIssueDate("2021-12-07");
        certificateOfFirstVersionOfSecondMedicine.setExpiryDate("2023-12-07");

        MedicinePackage medicinePackageOfFirstVersionOfSecondMedicine =
                new MedicinePackage(PackageType.BLISTER, 10, 7);

        Dosage dosageOfFirstVersionOfSecondMedicine = new Dosage(400, 6);

        return new Version(VersionName.CAPSULES, "Egis Pharmaceutical", certificateOfFirstVersionOfSecondMedicine,
                medicinePackageOfFirstVersionOfSecondMedicine, dosageOfFirstVersionOfSecondMedicine);
    }

    private Version createSecondVersionOfVascularMedicine() {
        Certificate certificateOfSecondVersionOfSecondMedicine = new Certificate();
        certificateOfSecondVersionOfSecondMedicine.setNumber("T9nkjSn93");
        certificateOfSecondVersionOfSecondMedicine.setIssueDate("2021-11-17");
        certificateOfSecondVersionOfSecondMedicine.setExpiryDate("2023-11-17");

        MedicinePackage medicinePackageOfSecondVersionOfSecondMedicine = new MedicinePackage(PackageType.BOTTLE,
                120, 8);

        Dosage dosageOfSecondVersionOfSecondMedicine = new Dosage(2333, 6);


        return new Version(VersionName.SOLUTION, "Meness", certificateOfSecondVersionOfSecondMedicine,
                medicinePackageOfSecondVersionOfSecondMedicine, dosageOfSecondVersionOfSecondMedicine);
    }

    private Version createThirdVersionOfVascularMedicine() {
        Certificate certificateOfThirdVersionOfSecondMedicine = new Certificate();
        certificateOfThirdVersionOfSecondMedicine.setNumber("BI1bksJHI");
        certificateOfThirdVersionOfSecondMedicine.setIssueDate("2021-10-27");
        certificateOfThirdVersionOfSecondMedicine.setExpiryDate("2023-10-27");

        MedicinePackage medicinePackageOfThirdVersionOfSecondMedicine = new MedicinePackage(PackageType.CARDBOARD_BOX,
                10, 10);

        Dosage dosageOfThirdVersionOfSecondMedicine = new Dosage(200, 6);


        return new Version(VersionName.PILLS, "TOGOS", certificateOfThirdVersionOfSecondMedicine,
                medicinePackageOfThirdVersionOfSecondMedicine, dosageOfThirdVersionOfSecondMedicine);
    }

    private Analogs createAnalogsOfVascularMedicine() {
        Analogs analogsOfVascularMedicine = new Analogs();
        analogsOfVascularMedicine.add("lucetam");
        analogsOfVascularMedicine.add("macsotropil");
        return analogsOfVascularMedicine;
    }
}
