package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.JMS.sender.Sender;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;
import se.iths.f12022statistics.repository.RaceRepository;
import se.iths.f12022statistics.repository.RaceResultRespository;
import se.iths.f12022statistics.responsehandling.NotFoundInDatabaseException;
import se.iths.f12022statistics.responsehandling.RaceAlreadyExistsException;
import org.springframework.jms.core.JmsTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceResultRespository raceResultRespository;
    private final JmsTemplate jmsTemplate;

    public RaceService(RaceRepository raceRepository, RaceResultRespository raceResultRespository, JmsTemplate jmsTemplate) {
        this.raceRepository = raceRepository;
        this.raceResultRespository = raceResultRespository;
        this.jmsTemplate = jmsTemplate;
    }

    public Race addNewRace(Race race) {
        Iterable<Race> foundRace = raceRepository.findAll();
        for (Race dbRace : foundRace) {
            if (dbRace.getTrackName().equals(race.getTrackName())) {
                throw new RaceAlreadyExistsException("That race already exists in the database.");
            }
        }

        // JMS here
        Sender sender = new Sender(jmsTemplate);
        sender.SendMessage("Added " + race.getTrackName() + " to race database");

        return raceRepository.save(race);
    }

    public Iterable<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Optional<Race> getRaceById(Long id) {

        Optional<Race> foundRace = raceRepository.findById(id);
        if (foundRace.isEmpty()) {
            throw new NotFoundInDatabaseException("Item with that id was not found in the database.");
        }
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
