package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medicine", propOrder = {"name", "group", "analogs", "versions"})
@XmlSeeAlso({HeartMedicine.class, VascularMedicine.class})
public abstract class Medicine {
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;
    @XmlElement(namespace = "http://www.epamcourses.by/medicins")
    private String name;
    @XmlElement(namespace = "http://www.epamcourses.by/medicins")
    private String group;
    @XmlElement(namespace = "http://www.epamcourses.by/medicins")
    private Analogs analogs;
    @XmlElement(namespace = "http://www.epamcourses.by/medicins")
    private Versions versions;

    public Medicine(String id, String name, String group,
                    Analogs analogs, Versions versions) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.analogs = analogs;
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medicine)) {
            return false;
        }
        Medicine medicine = (Medicine) o;
        return id.equals(medicine.id)
                && name.equals(medicine.name)
                && group.equals(medicine.group)
                && analogs.equals(medicine.analogs)
                && versions.equals(medicine.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, group, analogs, versions, versions);
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + analogs +
                ", version=" + versions +
                ", versions=" + versions +
                '}';
    }
}
