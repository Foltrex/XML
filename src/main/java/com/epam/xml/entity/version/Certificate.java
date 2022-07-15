package com.epam.xml.entity.version;

import com.epam.xml.logic.DateAdapter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Certificate", propOrder = {"number", "issueDate", "expiryDate"})
public class Certificate {
    @XmlElement(name = "number", namespace = "http://www.epamcourses.by/medicins")
    private String number;
    @XmlElement(name = "issue-date", namespace = "http://www.epamcourses.by/medicins")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date issueDate;
    @XmlElement(name = "expiry-date", namespace = "http://www.epamcourses.by/medicins")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date expiryDate;

    public void setIssueDate(String issueDate) {
        this.issueDate = parseDate(issueDate);
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = parseDate(expiryDate);
    }
    private Date parseDate(String info) {
        String[] words = info.split("[-/]");
        int year = Integer.parseInt(words[0]);
        int month = Integer.parseInt(words[1]);
        int day = Integer.parseInt(words[2]);
        return new Date(year, month, day);
    }
}
