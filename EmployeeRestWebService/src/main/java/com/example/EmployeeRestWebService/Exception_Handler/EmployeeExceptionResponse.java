package com.example.EmployeeRestWebService.Exception_Handler;

import java.util.Date;

public class EmployeeExceptionResponse {
    private String ErrorMessage,description;
    private Date DateAndTime;

    public EmployeeExceptionResponse(String errorMessage, String description, Date dateAndTime) {
        ErrorMessage = errorMessage;
        this.description = description;
        DateAndTime = dateAndTime;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateAndTime(Date dateAndTime) {
        DateAndTime = dateAndTime;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateAndTime() {
        return DateAndTime;
    }
}
