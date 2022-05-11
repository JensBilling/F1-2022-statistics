package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.JMS.sender.Sender;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;
import se.iths.f12022statistics.repository.RaceRepository;
import se.iths.f12022statistics.repository.RaceResultRepository;
import se.iths.f12022statistics.responsehandling.NotFoundInDatabaseException;
import se.iths.f12022statistics.responsehandling.EntityAlreadyExistsException;
import org.springframework.jms.core.JmsTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceResultRepository raceResultRepository;
    private final JmsTemplate jmsTemplate;

    public RaceService(RaceRepository raceRepository, RaceResultRepository raceResultRepository, JmsTemplate jmsTemplate) {
        this.raceRepository = raceRepository;
        this.raceResultRepository = raceResultRepository;
        this.jmsTemplate = jmsTemplate;
    }

    public Race addNewRace(Race race) {
        Iterable<Race> foundRace = raceRepository.findAll();
        for (Race dbRace : foundRace) {
            if (dbRace.getTrackName().equals(race.getTrackName())) {
                throw new EntityAlreadyExistsException("That race already exists in the database.");
            }
        }

        // JMS here
        Sender sender = new Sender(jmsTemplate);
        sender.SendMessage(race.getTrackName());

        return raceRepository.save(race);
    }

    public Optional<Race> getRaceById(Long id) {
        Optional<Race> foundRace = retrieveRaceFromDB(id);
        return foundRace;
    }

    public Race addNewRace(Race race) {
        Iterable<Race> foundRace = raceRepository.findAll();
        for (Race dbRace : foundRace) {
            if (dbRace.getTrackName().equals(race.getTrackName())) {
                throw new EntityAlreadyExistsException("That race already exists in the database.");
            }
        }
        Sender sender = new Sender(jmsTemplate);
        sender.SendMessage(race.getTrackName());
        return raceRepository.save(race);
    }

    public void deleteRaceFromDatabase(Long id) {
        Optional<Race> foundRace = retrieveRaceFromDB(id);
        raceRepository.delete(foundRace.get());
    }


    public void addRaceResultToRace(Long raceId, Long raceResultId) {
        Optional<Race> foundRace = retrieveRaceFromDB(raceId);
        Optional<RaceResult> foundRaceResult = raceResultRepository.findById(raceResultId);

        if (foundRaceResult.isEmpty()) {
            throw new NotFoundInDatabaseException("RaceResult with that id was not found in the database.");
        }
        for (RaceResult raceResult : foundRace.get().getRaceResults()) {
            if (raceResult.getId() == foundRaceResult.get().getId()) {
                throw new EntityAlreadyExistsException("That race result already exists in the race.");
            }
        }
        List<RaceResult> foundResultList = foundRace.get().getRaceResults();
        foundResultList.add(foundRaceResult.get());
        foundRace.get().setRaceResults(foundResultList);

        raceRepository.save(foundRace.get());
    }

    private Optional<Race> retrieveRaceFromDB(Long id) {
        Optional<Race> foundRace = raceRepository.findById(id);
        if (foundRace.isEmpty()) {
            throw new NotFoundInDatabaseException("Race with that id was not found in the database.");
        }
        return foundRace;
    }
}
