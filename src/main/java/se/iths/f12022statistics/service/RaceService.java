package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;
import se.iths.f12022statistics.repository.RaceRepository;
import se.iths.f12022statistics.repository.RaceResultRespository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceResultRespository raceResultRespository;

    public RaceService(RaceRepository raceRepository, RaceResultRespository raceResultRespository) {
        this.raceRepository = raceRepository;
        this.raceResultRespository = raceResultRespository;
    }

    public Race addNewRace(Race race) {
        return raceRepository.save(race);
    }

    public Iterable<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race getRaceById(Long id) {
        Race foundRace = raceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return foundRace;
    }

    public void deleteRaceFromDatabase(Long id) {
        Race foundRace = raceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        raceRepository.delete(foundRace);
    }


    public void addRaceResultToRace(Long raceId, Long raceResultId) {
        Race foundRace = raceRepository.findById(raceId).orElseThrow(EntityNotFoundException::new);
        RaceResult foundRaceResult = raceResultRespository.findById(raceResultId).orElseThrow(EntityNotFoundException::new);

        List<RaceResult> foundResultList = foundRace.getRaceResults();
        foundResultList.add(foundRaceResult);
        foundRace.setRaceResults(foundResultList);

        raceRepository.save(foundRace);
    }
}
