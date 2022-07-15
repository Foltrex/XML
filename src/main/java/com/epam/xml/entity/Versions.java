package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
@ToString
@Getter
@XmlRootElement(name = "versions", namespace = "http://www.epamcourses.by/medicins")
public class Versions {
    @XmlElement(name = "version", namespace = "http://www.epamcourses.by/medicins")
    private final List<Version> versions = new ArrayList<>();

    public boolean add(Version version) {
        return versions.add(version);
    }
}
