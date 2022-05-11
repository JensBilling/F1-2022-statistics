package se.iths.f12022statistics.service;

import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.repository.BossRepository;
import se.iths.f12022statistics.repository.DriverRepository;
import se.iths.f12022statistics.repository.TeamRepository;
import se.iths.f12022statistics.responsehandling.EntityAlreadyExistsException;
import se.iths.f12022statistics.responsehandling.NotFoundInDatabaseException;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private BossRepository bossRepository;
    private DriverRepository driverRepository;

    public TeamService(TeamRepository teamRepository, BossRepository bossRepository, DriverRepository driverRepository) {
        this.teamRepository = teamRepository;
        this.bossRepository = bossRepository;
        this.driverRepository = driverRepository;
    }

    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        Optional<Team> foundTeam = retrieveTeam(id);
        return foundTeam.get();
    }

    public Team addNewTeam(Team team) {

        Iterable<Team> foundTeam = teamRepository.findAll();
        for (Team dbTeam : foundTeam) {
            if (dbTeam.getName().equals(team.getName())) {
                throw new EntityAlreadyExistsException("That team already exists in the database.");
            }
        }
        teamRepository.save(team);
        return team;
    }

    public void deleteTeamFromDatabase(Long id) {
        Optional<Team> foundTeam = retrieveTeam(id);
        teamRepository.delete(foundTeam.get());
    }

    public String addBossToTeam(Long teamId, Long bossId) {
        Optional<Team> foundTeam = retrieveTeam(teamId);
        Optional<Boss> foundBoss = bossRepository.findById(bossId);
        if (foundBoss.isEmpty()) {
            throw new NotFoundInDatabaseException("No boss with that id found in database");
        }

        foundTeam.get().setBoss(foundBoss.get());
        teamRepository.save(foundTeam.get());
        return foundBoss.get().getName();
    }

    public String addDriverToTeam(Long teamId, Long driverId) {
        Optional<Team> foundTeam = retrieveTeam(teamId);
        Optional<Driver> foundDriver = driverRepository.findById(driverId);

        if (foundDriver.isEmpty()) {
            throw new NotFoundInDatabaseException("No driver with that id found in database");
        }

        List<Driver> foundDriverList = foundTeam.get().getDrivers();
        foundDriverList.add(foundDriver.get());
        foundTeam.get().setDrivers(foundDriverList);
        teamRepository.save(foundTeam.get());
        return foundDriver.get().getName();
    }

    private Optional<Team> retrieveTeam(Long id) {
        Optional<Team> foundTeam = teamRepository.findById(id);
        if (foundTeam.isEmpty()) {
            throw new NotFoundInDatabaseException("No team found with that id in database");
        }
        return foundTeam;
    }
}
