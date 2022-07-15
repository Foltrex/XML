package com.epam.xml.entity.version;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@Data
@NoArgsConstructor
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

    public Version(VersionName versionName, String pharm, Certificate certificate, MedicinePackage medicinePackage, Dosage dosage) {
        this.versionName = versionName;
        this.pharm = pharm;
        this.certificate = certificate;
        this.medicinePackage = medicinePackage;
        this.dosage = dosage;
    }
}
