package com.epam.xml.entity.version;

import java.util.Objects;

public class Version {
    private String pharm;
    private Certificate certificate;
    private MedicinePackage medicinePackage;
    private Dosage dosage;

    public Version(String pharm, Certificate certificate, MedicinePackage medicinePackage, Dosage dosage) {
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
