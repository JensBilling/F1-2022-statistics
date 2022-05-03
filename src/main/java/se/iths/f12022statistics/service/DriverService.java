package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.repository.DriverRepository;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}
