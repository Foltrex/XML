package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "analogs", namespace = "http://www.epamcourses.by/medicins")
public class Analogs {
    @XmlElement(name = "analog", namespace = "http://www.epamcourses.by/medicins")
    private List<String> analogs = new ArrayList<>();

    public boolean add(String analog) {
        return analogs.add(analog);
    }

    public List<String> getAnalogs() {
        return analogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Analogs)) {
            return false;
        }
        Analogs analogsSecond = (Analogs) o;
        return Objects.equals(analogs, analogsSecond.getAnalogs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(analogs);
    }

    @Override
    public String toString() {
        return "Analogs{" +
                "analogs=" + analogs +
                '}';
    }
}
