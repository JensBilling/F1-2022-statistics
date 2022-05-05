package se.iths.f12022statistics.responsehandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {NotFoundInDatabaseException.class})
    public ResponseEntity<Object> handleNotFoundInDatabaseException(NotFoundInDatabaseException e) {
        // create payload containing exception details
        APIException apiException = new APIException("Item with that id was not found in the database.", HttpStatus.NOT_FOUND);
        // return response entity
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {NotSignedInException.class})
    public ResponseEntity<Object> handleNotSignedInException(NotSignedInException e) {
        APIException apiException = new APIException("You have to be a signed in user to do that", HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(apiException, HttpStatus.UNAUTHORIZED);
    }


}
