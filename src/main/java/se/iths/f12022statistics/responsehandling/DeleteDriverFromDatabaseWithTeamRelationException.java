package se.iths.f12022statistics.responsehandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteDriverFromDatabaseWithTeamRelationException extends RuntimeException {

    public DeleteDriverFromDatabaseWithTeamRelationException(String error) {
        super(error);
    }
}
