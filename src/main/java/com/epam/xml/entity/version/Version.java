package com.epam.xml.entity.version;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version", propOrder = {"versionName", "pharm", "certificate","medicinePackage", "dosage"})
public class Version {
    @XmlElement(name = "version-name", namespace = "http://www.epamcourses.by/medicins")
    private VersionName versionName;
    @XmlElement(name = "pharm", namespace = "http://www.epamcourses.by/medicins")
    private String pharm;
    @XmlElement(name = "certificate", namespace = "http://www.epamcourses.by/medicins")
    private Certificate certificate;
    @XmlElement(name = "package", namespace = "http://www.epamcourses.by/medicins")
    private MedicinePackage medicinePackage;
    @XmlElement(name = "dosage", namespace = "http://www.epamcourses.by/medicins")
    private Dosage dosage;

    public Version() {
    }

    public Version(VersionName versionName, String pharm, Certificate certificate, MedicinePackage medicinePackage, Dosage dosage) {
        this.versionName = versionName;
        this.pharm = pharm;
        this.certificate = certificate;
        this.medicinePackage = medicinePackage;
        this.dosage = dosage;
    }

    public void setVersionName(VersionName versionName) {
        this.versionName = versionName;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public void setMedicinePackage(MedicinePackage medicinePackage) {
        this.medicinePackage = medicinePackage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public VersionName getVersionName() {
        return versionName;
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
        return versionName == version.getVersionName()
                && Objects.equals(pharm, version.getPharm())
                && Objects.equals(certificate, version.getCertificate())
                && Objects.equals(medicinePackage, version.getMedicinePackage())
                && Objects.equals(dosage, version.getDosage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionName, pharm, certificate, medicinePackage, dosage);
    }

    @Override
    public String toString() {
        return "Version{" +
                "versionName=" + versionName +
                ", pharm='" + pharm + '\'' +
                ", certificate=" + certificate +
                ", medicinePackage=" + medicinePackage +
                ", dosage=" + dosage +
                '}';
    }
}
