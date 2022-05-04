package se.iths.f12022statistics.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("")
    public ResponseEntity<Driver> addNewDriver(@RequestBody Driver driver){
        driverService.addNewDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteDriverFromDatabase(@RequestParam("id") Long id){
        driverService.DeleteDriverFromDatabase(id);
        return ResponseEntity.ok("Driver with id: " + id + " removed from DB");
    }
}
