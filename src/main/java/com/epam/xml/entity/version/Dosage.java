package com.epam.xml.entity.version;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dosage", propOrder = {"dose", "medicationInterval"})
public class Dosage {
    @XmlElement(name = "dose", namespace = "http://www.epamcourses.by/medicins")
    private int dose;
    @XmlElement(name = "medication-interval", namespace = "http://www.epamcourses.by/medicins")
    private int medicationInterval;

    /**
     * @param dose amount of medication taken in milligrams
     * @param medicationInterval time between appointments in hours
     */
    public Dosage(int dose, int medicationInterval) {
        this.dose = dose;
        this.medicationInterval = medicationInterval;
    }
}
