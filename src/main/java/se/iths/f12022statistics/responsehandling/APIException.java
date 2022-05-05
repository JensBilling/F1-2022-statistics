package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class APIException {
    private final String message;
    private final HttpStatus httpStatus;
    private final int httpCode;
    private final LocalDateTime timestamp;

    public APIException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpCode = httpStatus.value();
        this.timestamp = LocalDateTime.now();
    }

}
