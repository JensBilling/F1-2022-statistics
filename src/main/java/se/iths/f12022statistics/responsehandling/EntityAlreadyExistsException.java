package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String error) {
        super(error);
    }

}
