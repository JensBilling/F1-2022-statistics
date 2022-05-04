package se.iths.f12022statistics.service;

import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;
import se.iths.f12022statistics.repository.RaceResultRespository;

import javax.persistence.EntityNotFoundException;

@Service
public class RaceResultService {

    private final RaceResultRespository raceResultRespository;

    public RaceResultService(RaceResultRespository raceResultRespository) {
        this.raceResultRespository = raceResultRespository;
    }


    public RaceResult createNewRaceResult(RaceResult raceResult) {
        return raceResultRespository.save(raceResult);
    }

    public RaceResult getRaceResultById(Long id) {
        RaceResult foundRace = raceResultRespository.findById(id).orElseThrow(EntityNotFoundException::new);
        return foundRace;
    }

}

