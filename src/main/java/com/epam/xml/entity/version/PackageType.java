package com.epam.xml.entity.version;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "type")
@XmlEnum
public enum PackageType {
    @XmlEnumValue("CARDBOARD BOX")
    CARDBOARD_BOX,
    @XmlEnumValue("BLISTER")
    BLISTER,
    @XmlEnumValue("BOTTLE")
    BOTTLE;
}
