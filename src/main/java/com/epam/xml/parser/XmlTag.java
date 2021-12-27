package com.epam.xml.parser;

import javax.print.DocFlavor;
import java.util.Locale;

public enum XmlTag {
    MEDICINS("medicins"),
    HEART_MEDICINE("heart-medicine"),
    VASCULAR_MEDICINE("vascular-medicine"),
    DOSAGE("dosage"),
    ID("id"),
    ANALOGS("analogs"),
    VERSIONS("versions"),
    VERSION("version"),
    CERTIFICATE("certificate"),
    MEDICINE_PACKAGE("package"),

    NAME("name"),
    GROUP("group"),
    ANALOG("analog"),
    VERSION_NAME("version-name"),
    PHARM("pharm"),
    CERTIFICATE_NUMBER("number"),
    ISSUE_DATE("issue-date"),
    EXPIRY_DATE("expiry-date"),
    PACKAGE_TYPE("type"),
    CAPACITY("capacity"),
    PRICE("price"),
    DOSE("dose"),
    MEDICATION_INTERVAL("medication-interval");

    private final String value;

    XmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static final char UNDERSCORE = '_';
    private static final char HYPEN = '-';
    public static XmlTag valueOfTag(String tag) {
        tag = tag.toUpperCase().replace(HYPEN, UNDERSCORE);
        return XmlTag.valueOf(tag);
    }
}
