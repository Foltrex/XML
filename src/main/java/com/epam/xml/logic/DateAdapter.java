package com.epam.xml.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

// Class for correct Jaxb date parsing
public class DateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String marshal(Date v) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(v);
        }
    }

    @Override
    public Date unmarshal(String v) {
        synchronized (dateFormat) {
            String[] words = v.split("[-/]");
            int year = Integer.parseInt(words[0]);
            int month = Integer.parseInt(words[1]);
            int day = Integer.parseInt(words[2]);
            return new Date(year, month, day);
        }
    }

}
