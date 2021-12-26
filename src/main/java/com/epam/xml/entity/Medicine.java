package com.epam.xml.entity;

import com.epam.xml.entity.version.Version;
import com.epam.xml.entity.version.VersionName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Medicine {
    private String id;
    private String name;
    private String group;
    private ArrayList<String> analogs;
    private Version version;

    private Map<VersionName, List<Version>> versions = new HashMap<>();

    public Medicine(String id, String name, String group,
                    ArrayList<String> analogs, VersionName versionName, Version version) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.analogs = analogs;
        this.version = version;
        addVersion(versionName, version);
    }

    private void addVersion(VersionName versionName, Version version) {
        versions.putIfAbsent(versionName, new ArrayList<>());
        List<Version> versionList = versions.get(versionName);
        versionList.add(version);
    }


    public List<Version> getVersionList(VersionName versionName) {
        return versions.get(versionName);
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
                && version.equals(medicine.version)
                && versions.equals(medicine.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, group, analogs, version, versions);
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + analogs +
                ", version=" + version +
                ", versions=" + versions +
                '}';
    }
}
