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
@XmlType(name = "MedicinePackage", propOrder = {"packageType", "capacity", "price"})
public class MedicinePackage {
    @XmlElement(name = "type", namespace = "http://www.epamcourses.by/medicins")
    private PackageType packageType;
    @XmlElement(name = "capacity", namespace = "http://www.epamcourses.by/medicins")
    private int capacity;
    @XmlElement(name = "price", namespace = "http://www.epamcourses.by/medicins")
    private double price;

    public MedicinePackage(PackageType packageType, int capacity, double price) {
        this.packageType = packageType;
        this.capacity = capacity;
        this.price = price;
    }

    public void setType(PackageType packageType) {
        this.packageType = packageType;
    }
}
