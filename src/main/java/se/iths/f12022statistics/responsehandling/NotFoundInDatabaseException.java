package se.iths.f12022statistics.responsehandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotFoundInDatabaseException extends RuntimeException {

    //private String errorDescription = " could not be located in the database: ";

    public NotFoundInDatabaseException(String message) {
        super(message);
        // errorDescription = "Id: " + query + errorDescription + databaseTable;
        //returnResponse(message);
    }

    private ResponseEntity<String> returnResponse(String message) {
        return new ResponseEntity(new ErrorMessage(message, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

}
