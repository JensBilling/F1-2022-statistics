package se.iths.f12022statistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;
import se.iths.f12022statistics.service.RaceResultService;
import se.iths.f12022statistics.service.RaceService;

import java.util.Optional;

@RestController
@RequestMapping("api/races")
public class RaceController {

    private final RaceService raceService;
    private final RaceResultService raceResultService;

    public RaceController(RaceService raceService, RaceResultService raceResultService) {
        this.raceService = raceService;
        this.raceResultService = raceResultService;
    }

    @PostMapping("add")
    public ResponseEntity<Race> addRace(@RequestBody Race race) {
        raceService.addNewRace(race);
        return ResponseEntity.ok(race);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Race>> getRaceById(@PathVariable Long id) {
        return ResponseEntity.ok(raceService.getRaceById(id));
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Race>> getAllRaces() {
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteRaceFromDatabase(@RequestParam("id") Long id) {
        raceService.deleteRaceFromDatabase(id);
        return ResponseEntity.ok("Race with id: " + id + " deleted from the database.");
    }

    @PostMapping("createraceresult")
    public ResponseEntity<RaceResult> createRaceResult(@RequestBody RaceResult raceResult) {
        raceResultService.createNewRaceResult(raceResult);
        return ResponseEntity.ok(raceResult);
    }


    @PostMapping("addraceresulttorace")
    public ResponseEntity<String> addRaceResultToRace(@RequestParam("raceid") Long raceId, @RequestParam("resultid") Long raceResultid) {
        raceService.addRaceResultToRace(raceId, raceResultid);
        return ResponseEntity.ok("Race result added to race");
    }


}
