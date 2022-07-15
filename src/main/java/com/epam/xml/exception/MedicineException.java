package com.epam.xml.exception;

public class MedicineException extends Exception {
    public MedicineException() {
        super();
    }

    public MedicineException(String message) {
        super(message);
    }

    public MedicineException(Exception ex) {
        super(ex);
    }

    public MedicineException(String message, Exception exception) {
        super(message, exception);
    }
}
