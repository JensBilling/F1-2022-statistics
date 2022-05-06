package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.repository.DriverRepository;
import se.iths.f12022statistics.repository.TeamRepository;
import se.iths.f12022statistics.responsehandling.EditDatabaseRelationException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class DriverService {

    private DriverRepository driverRepository;
    private TeamRepository teamRepository;

    public DriverService(DriverRepository driverRepository, TeamRepository teamRepository){
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    public Driver addNewDriver(Driver driver){
        driverRepository.save(driver);
        return driver;
    }

    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        Driver foundDriver = driverRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return foundDriver;
    }

    public void deleteDriverFromDatabase(Long id) {
        Iterable<Team> allTeams = teamRepository.findAll();
        for (Team team : allTeams) {
            for (Driver driver : team.getDrivers()) {
                if (driver.getId() == id){
                    throw new EditDatabaseRelationException("You can not delete a driver that is assigned to a team, remove team relation before you try again.");
                }
            }
        }
        Driver foundDriver = driverRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        driverRepository.delete(foundDriver);



    }
}
