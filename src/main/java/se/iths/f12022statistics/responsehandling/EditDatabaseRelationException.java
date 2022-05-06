package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditDatabaseRelationException extends RuntimeException {

    public EditDatabaseRelationException(String error) {
        super(error);
    }
}
