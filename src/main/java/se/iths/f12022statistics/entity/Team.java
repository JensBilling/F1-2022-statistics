package se.iths.f12022statistics.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String engineManufacturer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Driver> drivers;
    @OneToOne(cascade = CascadeType.ALL)
    private Boss boss;

    public Team() {
    }

    public Team(String name, String engineManufacturer) {
        this.name = name;
        this.engineManufacturer = engineManufacturer;
    }

    public Team(String name, String engineManufacturer, List<Driver> drivers, Boss boss) {
        this.name = name;
        this.engineManufacturer = engineManufacturer;
        this.drivers = drivers;
        this.boss = boss;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineManufacturer() {
        return engineManufacturer;
    }

    public void setEngineManufacturer(String engineManufacturer) {
        this.engineManufacturer = engineManufacturer;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
