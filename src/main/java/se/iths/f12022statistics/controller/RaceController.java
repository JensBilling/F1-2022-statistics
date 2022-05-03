package se.iths.f12022statistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.repository.RaceRepository;
import se.iths.f12022statistics.service.RaceService;

@RestController
@RequestMapping("race")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping("")
    public ResponseEntity<Race> addRace(@RequestBody Race race){
        raceService.addNewRace(race);
        return ResponseEntity.ok(race);
    }

}
