package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceAlreadyExistsException extends RuntimeException {

    public RaceAlreadyExistsException(String error) {
        super(error);
    }

}
