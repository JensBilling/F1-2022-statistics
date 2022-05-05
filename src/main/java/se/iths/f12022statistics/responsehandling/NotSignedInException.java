package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotSignedInException extends RuntimeException {

    public NotSignedInException(String error) {
        super(error);
    }

}
