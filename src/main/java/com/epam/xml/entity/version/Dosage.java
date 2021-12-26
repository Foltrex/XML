package com.epam.xml.entity.version;

import java.util.Objects;

public class Dosage {
    private int dose;
    private int medicationInterval;

    /**
     * @param dose amount of medication taken in milligrams
     * @param medicationInterval time between appointments in hours
     */
    public Dosage(int dose, int medicationInterval) {
        this.dose = dose;
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
