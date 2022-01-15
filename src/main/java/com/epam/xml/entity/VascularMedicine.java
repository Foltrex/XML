package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;
import com.epam.xml.entity.version.VersionName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VascularMedicine")
public class VascularMedicine extends Medicine {

    public VascularMedicine() {
        super();
    }

    public VascularMedicine(String id, String name, String group, Analogs analogs, Versions versions) {
        super(id, name, group, analogs, versions);
    }


    @Override
    public String toString() {
        return "VascularMedicine" + super.toString();
    }
}
