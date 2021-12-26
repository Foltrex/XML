package com.epam.xml.entity.version;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "version-name")
@XmlEnum
public enum VersionName {
    @XmlEnumValue("PILLS")
    PILLS,
    @XmlEnumValue("CAPSULES")
    CAPSULES,
    @XmlEnumValue("POWDER")
    POWDER,
    @XmlEnumValue("DROPS")
    DROPS,
    @XmlEnumValue("SOLUTION")
    SOLUTION
}
