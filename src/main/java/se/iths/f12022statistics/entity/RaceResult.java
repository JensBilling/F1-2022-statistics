package se.iths.f12022statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RaceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long driverId;
    private Long driverPlacement;


    public RaceResult(Long driverId, Long driverPlacement) {
        this.driverId = driverId;
        this.driverPlacement = driverPlacement;
    }

    public RaceResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getDriverPlacement() {
        return driverPlacement;
    }

    public void setDriverPlacement(Long driverPlacement) {
        this.driverPlacement = driverPlacement;
    }
}
