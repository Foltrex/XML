package com.epam.xml.entity.version;

import javax.xml.bind.annotation.*;
import java.util.Calendar;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Certificate", propOrder = {"number", "issueDate", "expiryDate"})
public class Certificate {
    @XmlElement(name = "number", namespace = "http://www.epamcourses.by/medicins")
    private String number;
    @XmlElement(name = "issue-date", namespace = "http://www.epamcourses.by/medicins")
    private Calendar issueDate;
    @XmlElement(name = "expiry-date", namespace = "http://www.epamcourses.by/medicins")
    private Calendar expiryDate;

    public Certificate() {
    }

    public Certificate(String number, Calendar issueDate, Calendar expiryDate) {
        this.number = number;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIssueDate(Calendar issueDate) {
        this.issueDate = issueDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }


    public String getNumber() {
        return number;
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public Calendar getExpiryDate() {
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
        return getNumber() == that.getNumber()
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
}
