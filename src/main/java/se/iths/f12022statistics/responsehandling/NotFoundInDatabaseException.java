package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class NotFoundInDatabaseException extends RuntimeException {

    public NotFoundInDatabaseException(String error) {
        super(error);
    }
}

