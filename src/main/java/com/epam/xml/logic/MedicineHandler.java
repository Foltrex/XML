package com.epam.xml.logic;

import com.epam.xml.entity.*;
import com.epam.xml.entity.version.*;
import com.epam.xml.parser.XmlTag;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MedicineHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(MedicineHandler.class);

    private static final String HEART_MEDICINE_TAG = XmlTag.HEART_MEDICINE.getValue();
    private static final String VASCULAR_MEDICINE_TAG = XmlTag.VASCULAR_MEDICINE.getValue();
    private static final String ANALOGS_TAG = XmlTag.ANALOGS.getValue();
    private static final String VERSIONS_TAG = XmlTag.VERSIONS.getValue();
    private static final String VERSION_TAG = XmlTag.VERSION.getValue();
    private static final String CERTIFICATE_TAG = XmlTag.CERTIFICATE.getValue();
    private static final String MEDICINE_PACKAGE_TAG = XmlTag.MEDICINE_PACKAGE.getValue();
    private static final String DOSAGE_TAG = XmlTag.DOSAGE.getValue();

    private final List<Medicine> medicins = new ArrayList<>();

    private Medicine currentMedicine;
    private Certificate currentCertificate;
    private Dosage currentDosage;
    private MedicinePackage currentMedicinePackage;
    private Version currentVersion;
    private XmlTag currentTag;
    private Analogs currentAnalogs;
    private Versions currentVersions;
    private final EnumSet<XmlTag> tags = EnumSet.range(XmlTag.NAME, XmlTag.MEDICATION_INTERVAL);

    public List<Medicine> getMedicins() {
        return medicins;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {

        if (qName.equals(HEART_MEDICINE_TAG)) {
            currentMedicine = new HeartMedicine();
            setAttributes(attributes);
        } else if (qName.equals(VASCULAR_MEDICINE_TAG)) {
            currentMedicine = new VascularMedicine();
            setAttributes(attributes);
        } else if (qName.equals(ANALOGS_TAG)) {
            currentAnalogs = new Analogs();
        } else if (qName.equals(VERSIONS_TAG)) {
            currentVersions = new Versions();
        } else if (qName.equals(VERSION_TAG)) {
            currentVersion = new Version();
        } else if (qName.equals(CERTIFICATE_TAG)) {
            currentCertificate = new Certificate();
        } else if (qName.equals(MEDICINE_PACKAGE_TAG)) {
            currentMedicinePackage = new MedicinePackage();
        } else if (qName.equals(DOSAGE_TAG)) {
            currentDosage = new Dosage();
        } else {
            XmlTag current = XmlTag.valueOfTag(qName);

            if (tags.contains(current)) {
                currentTag = current;
            }
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String info = new String(chars, start, length).trim();

        if (!info.isEmpty() && currentTag != null) {
            switch (currentTag) {
                case NAME:
                    currentMedicine.setName(info);
                    break;
                case GROUP:
                    currentMedicine.setGroup(info);
                    break;
                case ANALOG:
                    currentAnalogs.add(info);
                    break;
                case VERSION_NAME:
                    VersionName versionName = VersionName.valueOf(info);
                    currentVersion.setVersionName(versionName);
                    break;
                case PHARM:
                    currentVersion.setPharm(info);
                    break;
                case NUMBER:
                    currentCertificate.setNumber(info);
                    break;
                case ISSUE_DATE:
                    currentCertificate.setIssueDate(info);
                    break;
                case EXPIRY_DATE:
                    currentCertificate.setExpiryDate(info);
                    break;
                case TYPE:
                    info = info.replace(' ', '_');
                    PackageType packageType = PackageType.valueOf(info);
                    currentMedicinePackage.setType(packageType);
                    break;
                case CAPACITY:
                    int capacity = Integer.parseInt(info);
                    currentMedicinePackage.setCapacity(capacity);
                    break;
                case PRICE:
                    int price = Integer.parseInt(info);
                    currentMedicinePackage.setPrice(price);
                    break;
                case DOSE:
                    int dose = Integer.parseInt(info);
                    currentDosage.setDose(dose);
                    break;
                case MEDICATION_INTERVAL:
                    int medicationInterval = Integer.parseInt(info);
                    currentDosage.setMedicationInterval(medicationInterval);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());
            }
        }

        currentTag = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equals(HEART_MEDICINE_TAG) || qName.equals(VASCULAR_MEDICINE_TAG)) {
            medicins.add(currentMedicine);
            LOGGER.info("Medicins added to list");
        } else if (qName.equals(ANALOGS_TAG)) {
            currentMedicine.setAnalogs(currentAnalogs);
            LOGGER.info("Medicins analogs were added");
        } else if (qName.equals(VERSIONS_TAG)) {
            currentMedicine.setVersions(currentVersions);
            LOGGER.info("Medicins versions were added");
        } else if (qName.equals(VERSION_TAG)) {
            currentVersions.add(currentVersion);
            LOGGER.info("Medicine version was added");
        } else if (qName.equals(CERTIFICATE_TAG)) {
            currentVersion.setCertificate(currentCertificate);
            LOGGER.info("Certificate was added");
        } else if (qName.equals(MEDICINE_PACKAGE_TAG)) {
            currentVersion.setMedicinePackage(currentMedicinePackage);
            LOGGER.info("Medicine package was added");
        } else if (qName.equals(DOSAGE_TAG)) {
            currentVersion.setDosage(currentDosage);
            LOGGER.info("Dosage was added");
        }
    }

    private void setAttributes(Attributes attributes) {
        String medicineId = attributes.getValue(XmlTag.ID.getValue());
        currentMedicine.setId(medicineId);
    }
}
