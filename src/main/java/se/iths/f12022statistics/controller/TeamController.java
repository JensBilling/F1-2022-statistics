package se.iths.f12022statistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.service.TeamService;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PostMapping("")
    public ResponseEntity<Team> addNewTeam(@RequestBody Team team) {
        teamService.addNewTeam(team);
        return ResponseEntity.ok(team);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteTeamFromDatabase(@RequestParam("id") Long id) {
        teamService.deleteTeamFromDatabase(id);
        return ResponseEntity.ok("Team with id: " + id + " removed from DB");
    }

    @PostMapping("addbosstoteam")
    public ResponseEntity<String> addBossToTeam(@RequestParam("teamid") Long teamId, @RequestParam("bossid") Long bossId) {
        String bossName = teamService.addBossToTeam(teamId, bossId);
        return ResponseEntity.ok(bossName + " added to team as boss!");
    }

    @PostMapping("adddrivertoteam")
    public ResponseEntity<String> addDriverToTeam(@RequestParam("teamid") Long teamId, @RequestParam("driverid") Long driverId) {
        String driverName = teamService.addDriverToTeam(teamId, driverId);
        return ResponseEntity.ok(driverName + " added to team as driver!");
    }
}
