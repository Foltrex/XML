package com.epam.xml.entity.version;

import com.epam.xml.logic.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = parseDate(issueDate);
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = parseDate(expiryDate);
    }


    public String getNumber() {
        return number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Certificate)) {
            return false;
        }
        Certificate that = (Certificate) o;
        return Objects.equals(number, that.getNumber())
                && Objects.equals(issueDate, that.getIssueDate())
                && Objects.equals(expiryDate, that.getExpiryDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, issueDate, expiryDate);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "number=" + number +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate + '\'' +
                '}';
    }

    private Date parseDate(String info) {
        String[] words = info.split("[-/]");
        int year = Integer.parseInt(words[0]);
        int month = Integer.parseInt(words[1]);
        int day = Integer.parseInt(words[2]);
        Date date = new Date(year, month, day);
        return date;
    }
}
