package com.epam.xml.entity.version;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicinePackage", propOrder = {"packageType", "capacity", "price"})
public class MedicinePackage {
    @XmlElement(name = "type", namespace = "http://www.epamcourses.by/medicins")
    private PackageType packageType;
    @XmlElement(name = "capacity", namespace = "http://www.epamcourses.by/medicins")
    private int capacity;
    @XmlElement(name = "price", namespace = "http://www.epamcourses.by/medicins")
    private double price;

    public MedicinePackage() {
    }

    public MedicinePackage(PackageType packageType, int capacity, double price) {
        this.packageType = packageType;
        this.capacity = capacity;
        this.price = price;
    }

    public void setType(PackageType packageType) {
        this.packageType = packageType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PackageType getPackageType() {
        return packageType;
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
                && Objects.equals(packageType, that.getPackageType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageType, capacity, price);
    }

    @Override
    public String toString() {
        return "MedicinePackage{" +
                "packageType='" + packageType + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
