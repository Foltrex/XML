package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;

import java.util.ArrayList;
import java.util.List;

public class Analogs {

    List<String> analogs = new ArrayList<>();

    public boolean add(String analog) {
        return analogs.add(analog);
    }

    public List<String> getAnalogs() {
        return analogs;
    }
}
