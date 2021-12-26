package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;

import java.util.ArrayList;
import java.util.List;

public class Versions {
    private List<Version> versions = new ArrayList<>();

    public boolean add(Version version) {
        return versions.add(version);
    }

    public List<Version> getVersions() {
        return versions;
    }
}
