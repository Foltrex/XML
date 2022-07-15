package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "medicins", namespace = "http://www.epamcourses.by/medicins")
public class Medicins {
    @XmlElements({
            @XmlElement(name = "heart-medicine", namespace = "http://www.epamcourses.by/medicins", type = HeartMedicine.class),
            @XmlElement(name = "vascular-medicine", namespace = "http://www.epamcourses.by/medicins", type = VascularMedicine.class)
    })
    private final List<Medicine> medicines = new ArrayList<>();

    public boolean add(Medicine medicine) {
        return medicines.add(medicine);
    }

    public List<Medicine> getMedicins() {
        return medicines;
    }
}
