package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "versions", namespace = "http://www.epamcourses.by/medicins")
public class Versions {
    @XmlElement(name = "version", namespace = "http://www.epamcourses.by/medicins")
    private List<Version> versions = new ArrayList<>();

    public boolean add(Version version) {
        return versions.add(version);
    }

    public List<Version> getVersions() {
        return versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Versions)) {
            return false;
        }
        Versions versionsSecond = (Versions) o;
        return Objects.equals(versions, versionsSecond.getVersions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(versions);
    }

    @Override
    public String toString() {
        return "Versions{" +
                "versions=" + versions +
                '}';
    }
}
