package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.repository.RaceRepository;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Race addNewRace(Race race) {
        return raceRepository.save(race);
    }
    public Iterable<Race> getAllRaces(){
        return raceRepository.findAll();
    }
}
