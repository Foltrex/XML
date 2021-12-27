package com.epam.xml.parser;

import com.epam.xml.entity.*;
import com.epam.xml.entity.version.*;
import com.epam.xml.exception.MedicineException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MedicineDomParser implements MedicineParser{
    @Override
    public List<Medicine> parse(String xmlPath) throws MedicineException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Medicine> medicins = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();

            createSpecifiedTypeOfMedicins(medicins, root, XmlTag.HEART_MEDICINE);
            createSpecifiedTypeOfMedicins(medicins, root, XmlTag.VASCULAR_MEDICINE);
        } catch (IOException | SAXException | ParserConfigurationException exception) {
            throw new MedicineException("Dom parser exception: ", exception);
        }

        return medicins;
    }

    private void createSpecifiedTypeOfMedicins(List<Medicine> medicins, Element root, XmlTag xmlTag) {
        NodeList medicinsList = root.getElementsByTagName(xmlTag.getValue());

        for (int i = 0; i < medicinsList.getLength(); ++i) {
            Element medicineElement = (Element) medicinsList.item(i);
            Medicine medicine = parseElement(medicineElement);
            medicins.add(medicine);
        }
    }


    private static final String HEART_MEDICINE_TAG = XmlTag.HEART_MEDICINE.getValue();

    private Medicine parseElement(Element medicineElement) {
        String medicineClass = medicineElement.getTagName();
        Medicine medicine;
        if (medicineClass.equals(HEART_MEDICINE_TAG)) {
            medicine = new HeartMedicine();
        } else {
            medicine = new VascularMedicine();
        }

        parseMedicineFields(medicineElement, medicine);

        return medicine;
    }


    private static final String MEDICINE_ID_TAG = XmlTag.ID.getValue();
    private static final String NAME_TAG = XmlTag.NAME.getValue();
    private static final String GROUP_TAG = XmlTag.GROUP.getValue();
    private static final String ANALOGS_TAG = XmlTag.ANALOGS.getValue();
    private static final String VERSIONS_TAG = XmlTag.VERSIONS.getValue();

    private void parseMedicineFields(Element medicineElement, Medicine medicine) {
        medicine.setId(medicineElement.getAttribute(MEDICINE_ID_TAG));

        String textContent = getElementTextContent(medicineElement, NAME_TAG);
        medicine.setName(textContent);

        textContent = getElementTextContent(medicineElement, GROUP_TAG);
        medicine.setGroup(textContent);



        Analogs analogs = new Analogs();
        Element analogsElement = getChildElement(medicineElement, ANALOGS_TAG);
        parseAnalogs(analogsElement, analogs);
        medicine.setAnalogs(analogs);

        Versions versions = new Versions();
        Element versionsElement = getChildElement(medicineElement, VERSIONS_TAG);
        parseVersions(versionsElement, versions);
        medicine.setVersions(versions);
    }


    private static final String ANALOG_TAG = XmlTag.ANALOG.getValue();

    private void parseAnalogs(Element analogsElement, Analogs analogs) {
        NodeList analogList = analogsElement.getElementsByTagName(ANALOG_TAG);

        for (int i = 0; i < analogList.getLength(); ++i) {
            Node analogNode = analogList.item(i);
            String textContent = analogNode.getTextContent();
            analogs.add(textContent);
        }
    }


    private static final String VERSION_TAG = XmlTag.VERSION.getValue();

    private void parseVersions(Element versionsElement, Versions versions) {
        NodeList versionList = versionsElement.getElementsByTagName(VERSION_TAG);

        for (int i = 0; i < versionList.getLength(); ++i) {
            Element versionElement = (Element) versionList.item(i);
            Version version = new Version();
            parseVersionFields(versionElement, version);
            versions.add(version);
        }
    }


    private static final String VERSION_NAME_TAG = XmlTag.VERSION_NAME.getValue();
    private static final String PHARM_TAG = XmlTag.PHARM.getValue();
    private static final String CERTIFICATE_TAG = XmlTag.CERTIFICATE.getValue();
    private static final String MEDICINE_PACKAGE_TAG = XmlTag.MEDICINE_PACKAGE.getValue();
    private static final String DOSAGE_TAG = XmlTag.DOSAGE.getValue();

    private void parseVersionFields(Element versionElement, Version version) {
        String textContent = getElementTextContent(versionElement, VERSION_NAME_TAG);
        VersionName versionName = VersionName.valueOf(textContent);
        version.setVersionName(versionName);

        textContent = getElementTextContent(versionElement, PHARM_TAG);
        version.setPharm(textContent);

        Certificate certificate = new Certificate();
        Element certificateElement = getChildElement(versionElement, CERTIFICATE_TAG);
        parseCertificateFields(certificateElement, certificate);
        version.setCertificate(certificate);

        MedicinePackage medicinePackage = new MedicinePackage();
        Element medicinePackageElement = getChildElement(versionElement, MEDICINE_PACKAGE_TAG);
        parseMedicinePackageFields(medicinePackageElement, medicinePackage);
        version.setMedicinePackage(medicinePackage);

        Dosage dosage = new Dosage();
        Element dosageElement = getChildElement(versionElement, DOSAGE_TAG);
        parseDosageFields(dosageElement, dosage);
        version.setDosage(dosage);
    }


    private static final String NUMBER_TAG = XmlTag.CERTIFICATE_NUMBER.getValue();
    private static final String ISSUE_DATE_TAG = XmlTag.ISSUE_DATE.getValue();
    private static final String EXPIRY_DATE_TAG = XmlTag.EXPIRY_DATE.getValue();

    private void parseCertificateFields(Element certificateElement, Certificate certificate) {
        String textContent = getElementTextContent(certificateElement, NUMBER_TAG);
        certificate.setNumber(textContent);

        textContent = getElementTextContent(certificateElement, ISSUE_DATE_TAG);
        Calendar issueDate = parseCalendar(textContent);
        certificate.setIssueDate(issueDate);

        textContent = getElementTextContent(certificateElement, EXPIRY_DATE_TAG);
        Calendar expiryDate = parseCalendar(textContent);
        certificate.setExpiryDate(expiryDate);
    }


    private static final String PACKAGE_TYPE_TAG = XmlTag.PACKAGE_TYPE.getValue();
    private static final String CAPACITY_TAG = XmlTag.CAPACITY.getValue();
    private static final String PRICE_TAG = XmlTag.PRICE.getValue();

    private void parseMedicinePackageFields(Element medicinePackageElement, MedicinePackage medicinePackage) {
        String textContent = getElementTextContent(medicinePackageElement, PACKAGE_TYPE_TAG);
        textContent.replace(' ', '_');
        PackageType packageType = PackageType.valueOf(textContent);
        medicinePackage.setType(packageType);

        textContent = getElementTextContent(medicinePackageElement, CAPACITY_TAG);
        int capacity = Integer.parseInt(textContent);
        medicinePackage.setCapacity(capacity);

        textContent = getElementTextContent(medicinePackageElement, PRICE_TAG);
        int price = Integer.parseInt(textContent);
        medicinePackage.setPrice(price);
    }


    private static final String DOSE_TAG = XmlTag.DOSE.getValue();
    private static final String MEDICATION_INTERVAL_TAG = XmlTag.MEDICATION_INTERVAL.getValue();

    private void parseDosageFields(Element dosageElement, Dosage dosage) {
        String textContent = getElementTextContent(dosageElement, DOSE_TAG);
        int dose = Integer.parseInt(textContent);
        dosage.setDose(dose);

        textContent = getElementTextContent(dosageElement, MEDICATION_INTERVAL_TAG);
        String[] words = textContent.split(" ");
        int medicationInterval = Integer.parseInt(words[0]);
        dosage.setMedicationInterval(medicationInterval);
    }

    private Element getChildElement(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        return (Element) nodeList.item(0);
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);

        return node.getTextContent();
    }

    private Calendar parseCalendar(String info) {
        Calendar calendar = null;
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(info);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }
}
