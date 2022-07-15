package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@XmlRootElement(name = "analogs", namespace = "http://www.epamcourses.by/medicins")
public class Analogs {
    @XmlElement(name = "analog", namespace = "http://www.epamcourses.by/medicins")
    private final List<String> analogs = new ArrayList<>();

    public boolean add(String analog) {
        return analogs.add(analog);
    }
}
