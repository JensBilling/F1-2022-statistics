package se.iths.f12022statistics.responsehandling;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private String errorDescription;
    private HttpStatus httpStatus;

    public ErrorMessage(String errorDescription, HttpStatus httpStatus) {
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
    }
}
