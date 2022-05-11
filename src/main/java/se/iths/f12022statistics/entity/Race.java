package se.iths.f12022statistics.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackName;
    private double trackDistance;
    private Long driverIdOfFastestLap;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RaceResult> raceResults = new ArrayList<>();

    public Race() {
    }


    public Race(String trackName, double trackDistance, Long driverIdOfFastestLap) {
        this.trackName = trackName;
        this.trackDistance = trackDistance;
        this.driverIdOfFastestLap = driverIdOfFastestLap;
    }

    public Race(String trackName, double trackDistance, Long driverIdOfFastestLap, List<RaceResult> raceResults) {
        this.trackName = trackName;
        this.trackDistance = trackDistance;
        this.driverIdOfFastestLap = driverIdOfFastestLap;
        this.raceResults = raceResults;
    }

    public Long getId() {
        return id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public double getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(double trackDistance) {
        this.trackDistance = trackDistance;
    }

    public Long getDriverIdOfFastestLap() {
        return driverIdOfFastestLap;
    }

    public void setDriverIdOfFastestLap(Long driverIdOfFastestLap) {
        this.driverIdOfFastestLap = driverIdOfFastestLap;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public void setRaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
    }
}
