package com.epam.xml.entity.version;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicinePackage", propOrder = {"type", "capacity", "price"})
public class MedicinePackage {
    @XmlElement(name = "type", namespace = "http://www.epamcourses.by/medicins")
    private String type;
    @XmlElement(name = "capacity", namespace = "http://www.epamcourses.by/medicins")
    private int capacity;
    @XmlElement(name = "price", namespace = "http://www.epamcourses.by/medicins")
    private double price;


    public MedicinePackage(String type, int capacity, double price) {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicinePackage)) {
            return false;
        }
        MedicinePackage that = (MedicinePackage) o;
        return capacity == that.getCapacity()
                && Double.compare(that.getPrice(), price) == 0
                && Objects.equals(type, that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, capacity, price);
    }

    @Override
    public String toString() {
        return "MedicinePackage{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
