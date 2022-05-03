package se.iths.f12022statistics.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.service.DriverService;
import se.iths.f12022statistics.service.RaceService;

@RestController
@RequestMapping("api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Driver>> getAllDriver(){
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

}
