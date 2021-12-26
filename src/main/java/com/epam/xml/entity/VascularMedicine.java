package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;
import com.epam.xml.entity.version.VersionName;

import java.util.ArrayList;

public class VascularMedicine extends Medicine {

    public VascularMedicine(String id, String name, String group, ArrayList<String> analogs, VersionName versionName, Version version) {
        super(id, name, group, analogs, versionName, version);
    }

    @Override
    public String toString() {
        return "VascularMedicine" + super.toString();
    }
}
