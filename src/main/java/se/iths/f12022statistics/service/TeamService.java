package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.repository.BossRepository;
import se.iths.f12022statistics.repository.DriverRepository;
import se.iths.f12022statistics.repository.TeamRepository;

import javax.persistence.EntityNotFoundException;
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

    public Team getDriverById(Long id) {
        Team foundTeam = teamRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return foundTeam;
    }

    public void deleteTeamFromDatabase(Long id) {
        Optional<Team> foundTeam = retrieveTeam(id);
        teamRepository.delete(foundTeam.get());
    }

    public String addBossToTeam(Long teamId, Long bossId) {
        Team foundTeam = teamRepository.findById(teamId).orElseThrow(EntityNotFoundException::new);
        Boss foundBoss = bossRepository.findById(bossId).orElseThrow(EntityNotFoundException::new);
        foundTeam.setBoss(foundBoss);
        teamRepository.save(foundTeam);
        return foundBoss.getName();
    }

    public String addDriverToTeam(Long teamId, Long driverId) {
        Team foundTeam = teamRepository.findById(teamId).orElseThrow(EntityNotFoundException::new);
        Driver foundDriver = driverRepository.findById(driverId).orElseThrow(EntityNotFoundException::new);
        List<Driver> foundDriverList = foundTeam.getDrivers();
        foundDriverList.add(foundDriver);
        foundTeam.setDrivers(foundDriverList);
        teamRepository.save(foundTeam);
        return foundDriver.getName();
    }

    private Optional<Team> retrieveTeam(Long id) {
        Optional<Team> foundTeam = teamRepository.findById(id);
        if (foundTeam.isEmpty()) {
            throw new NotFoundInDatabaseException("No team found with that id in database");
        }
        return foundTeam;
    }
}
