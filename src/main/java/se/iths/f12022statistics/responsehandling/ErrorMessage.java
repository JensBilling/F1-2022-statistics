package se.iths.f12022statistics.responsehandling;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private HttpStatus httpStatus;
    private int httpCode;
    private String errorDescription;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorDescription, HttpStatus httpStatus, int httpCode) {
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
    }
}
