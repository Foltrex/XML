package com.epam.xml.exception;

public class MedicineException extends Exception {
    public MedicineException(String message, Exception exception) {
        super(message, exception);
    }
}
