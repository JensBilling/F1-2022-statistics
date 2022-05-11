package se.iths.f12022statistics.responsehandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {NotFoundInDatabaseException.class})
    public ResponseEntity<Object> handleNotFoundInDatabaseException(NotFoundInDatabaseException e) {
        // create payload containing exception details
        APIException apiException = new APIException("Entity with that id was not found in the database.", HttpStatus.NOT_FOUND);
        // return response entity
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<Object> handleNotSignedInException(EntityAlreadyExistsException e) {
        APIException apiException = new APIException("That entity already exists in the database.", HttpStatus.CONFLICT);
        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {DeleteDriverFromDatabaseWithTeamRelationException.class})
    public ResponseEntity<Object> handleEditDatabaseRelationException(DeleteDriverFromDatabaseWithTeamRelationException e) {
        APIException apiException = new APIException("You can not delete a driver that is assigned to a team, remove team relation before you try again.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }


}
