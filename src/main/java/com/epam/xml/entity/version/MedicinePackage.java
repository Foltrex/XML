package com.epam.xml.entity.version;

import java.util.Objects;

public class MedicinePackage {
    private String type;
    private int capacity;
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
