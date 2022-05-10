package se.iths.f12022statistics.service;

import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;
import se.iths.f12022statistics.repository.RaceResultRespository;
import se.iths.f12022statistics.responsehandling.EntityAlreadyExistsException;
import se.iths.f12022statistics.responsehandling.NotFoundInDatabaseException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RaceResultService {

    private final RaceResultRespository raceResultRespository;

    public RaceResultService(RaceResultRespository raceResultRespository) {
        this.raceResultRespository = raceResultRespository;
    }

    public RaceResult createNewRaceResult(RaceResult raceResult) {
        Iterable<RaceResult> foundRaceResult = raceResultRespository.findAll();
        for (RaceResult dbRaceResult : foundRaceResult) {
            if (dbRaceResult.getDriverId() == raceResult.getDriverId()) {
                throw new EntityAlreadyExistsException("That result is already in the database.");
            }
        }
        return raceResultRespository.save(raceResult);
    }
}

