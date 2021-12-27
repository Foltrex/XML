package com.epam.xml.entity.version;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dosage", propOrder = {"dose", "medicationInterval"})
public class Dosage {
    @XmlElement(name = "dose", namespace = "http://www.epamcourses.by/medicins")
    private int dose;
    @XmlElement(name = "medication-interval", namespace = "http://www.epamcourses.by/medicins")
    private int medicationInterval;

    public Dosage() {
    }

    /**
     * @param dose amount of medication taken in milligrams
     * @param medicationInterval time between appointments in hours
     */
    public Dosage(int dose, int medicationInterval) {
        this.dose = dose;
        this.medicationInterval = medicationInterval;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setMedicationInterval(int medicationInterval) {
        this.medicationInterval = medicationInterval;
    }


    public double getDose() {
        return dose;
    }

    public int getMedicationInterval() {
        return medicationInterval;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dosage)) {
            return false;
        }
        Dosage dosage = (Dosage) o;
        return dose == dosage.getDose()
                && medicationInterval == dosage.getMedicationInterval();
    }

    @Override
    public int hashCode() {
        return Objects.hash(dose, medicationInterval);
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "dose=" + dose +
                ", medicationInterval=" + medicationInterval +
                '}';
    }
}
