package se.iths.f12022statistics.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Driver {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    private Team team;
    @ManyToMany
    private List<Race> raceList;

    public Driver() {
    }

    public Driver(String name, int age, Team team, List<Race> raceList) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.raceList = raceList;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }
}