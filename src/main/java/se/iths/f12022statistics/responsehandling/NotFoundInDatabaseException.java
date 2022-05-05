package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundInDatabaseException extends RuntimeException {

    public NotFoundInDatabaseException(String error) {
        super(error);
    }
}

