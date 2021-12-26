package com.epam.xml.entity.version;

import java.util.Calendar;
import java.util.Objects;

public class Certificate {
    private int number;
    private Calendar issueDate;
    private Calendar expiryDate;
    private String registeringOrganization;

    public Certificate(int number, Calendar issueDate, Calendar expiryDate, String registeringOrganization) {
        this.number = number;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.registeringOrganization = registeringOrganization;
    }

    public int getNumber() {
        return number;
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public String getRegisteringOrganization() {
        return registeringOrganization;
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
                && Objects.equals(expiryDate, that.getExpiryDate())
                && Objects.equals(registeringOrganization, that.getRegisteringOrganization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, issueDate, expiryDate, registeringOrganization);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "number=" + number +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", registeringOrganization='" + registeringOrganization + '\'' +
                '}';
    }
}
