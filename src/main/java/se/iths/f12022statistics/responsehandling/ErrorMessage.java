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
        this.httpCode = httpCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
