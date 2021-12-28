package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;
import com.epam.xml.entity.version.VersionName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeartMedicine")
public class HeartMedicine extends Medicine {

    public HeartMedicine() {
        super();
    }

    public HeartMedicine(String id, String name, String group, Analogs analogs, Versions versions) {
        super(id, name, group, analogs, versions);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "HeartMedicine" + super.toString();
    }
}
