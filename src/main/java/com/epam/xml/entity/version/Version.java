package com.epam.xml.entity.version;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version", propOrder = {"pharm", "certificate","medicinePackage", "dosage"})
public class Version {
    @XmlAttribute(name = "version-name")
    private VersionName versionName;
    @XmlElement(name = "pharm", namespace = "http://www.epamcourses.by/medicins")
    private String pharm;
    @XmlElement(name = "certificate", namespace = "http://www.epamcourses.by/medicins")
    private Certificate certificate;
    @XmlElement(name = "medicine-package", namespace = "http://www.epamcourses.by/medicins")
    private MedicinePackage medicinePackage;
    @XmlElement(name = "dosage", namespace = "http://www.epamcourses.by/medicins")
    private Dosage dosage;

    public Version(VersionName versionName, String pharm, Certificate certificate, MedicinePackage medicinePackage, Dosage dosage) {
        this.versionName = versionName;
        this.pharm = pharm;
        this.certificate = certificate;
        this.medicinePackage = medicinePackage;
        this.dosage = dosage;
    }

    public String getPharm() {
        return pharm;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public MedicinePackage getMedicinePackage() {
        return medicinePackage;
    }

    public Dosage getDosage() {
        return dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Version)) {
            return false;
        }
        Version version = (Version) o;
        return pharm.equals(version.getPharm())
                && certificate.equals(version.getCertificate())
                && medicinePackage.equals(version.getMedicinePackage())
                && dosage.equals(version.getDosage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharm, certificate, medicinePackage, dosage);
    }

    @Override
    public String toString() {
        return "Version{" +
                "pharm='" + pharm + '\'' +
                ", certificate=" + certificate +
                ", medicinePackage=" + medicinePackage +
                ", dosage=" + dosage +
                '}';
    }
}
