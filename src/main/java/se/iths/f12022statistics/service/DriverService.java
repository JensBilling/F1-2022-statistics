package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.repository.DriverRepository;
import se.iths.f12022statistics.repository.TeamRepository;
import se.iths.f12022statistics.responsehandling.DeleteDriverFromDatabaseWithTeamRelationException;
import se.iths.f12022statistics.responsehandling.EntityAlreadyExistsException;
import se.iths.f12022statistics.responsehandling.NotFoundInDatabaseException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DriverService {

    private DriverRepository driverRepository;
    private TeamRepository teamRepository;

    public DriverService(DriverRepository driverRepository, TeamRepository teamRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        Optional<Driver> foundDriver = retrieveDriverFromDB(id);
        return foundDriver.get();
    }

    public Driver addNewDriver(Driver driver) {
        Iterable<Driver> foundDriver = driverRepository.findAll();
        for (Driver dbDriver : foundDriver) {
            if (dbDriver.getName().equals(driver.getName())) {
                throw new EntityAlreadyExistsException("That driver already exists in the database.");
            }
        }
        driverRepository.save(driver);
        return driver;
    }

    public void deleteDriverFromDatabase(Long id) {
        Iterable<Team> allTeams = teamRepository.findAll();
        for (Team team : allTeams) {
            for (Driver driver : team.getDrivers()) {
                if (driver.getId() == id) {
                    throw new DeleteDriverFromDatabaseWithTeamRelationException("You can not delete a driver that is assigned to a team, remove team relation before you try again.");
                }
            }
        }
        Optional<Driver> foundDriver = retrieveDriverFromDB(id);
        driverRepository.delete(foundDriver.get());
    }

    private Optional<Driver> retrieveDriverFromDB(Long id) {
        Optional<Driver> foundDriver = driverRepository.findById(id);
        if (foundDriver.isEmpty()) {
            throw new NotFoundInDatabaseException("Driver with that id was not found in the database.");
        }
        return foundDriver;
    }
}
