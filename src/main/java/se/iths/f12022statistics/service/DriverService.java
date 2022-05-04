package se.iths.f12022statistics.service;


import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.repository.DriverRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
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

    public void DeleteDriverFromDatabase(Long id) {
        Driver foundDriver = driverRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        driverRepository.delete(foundDriver);
    }
}
