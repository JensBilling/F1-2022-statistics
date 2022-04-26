package se.iths.f12022statistics.entity;


import javax.persistence.*;

@Entity
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private int yearsAsTeamBoss;


    public Boss() {
    }

    public Boss(String name, int age, int yearsAsTeamBoss) {
        this.name = name;
        this.age = age;
        this.yearsAsTeamBoss = yearsAsTeamBoss;

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

    public int getYearsAsTeamBoss() {
        return yearsAsTeamBoss;
    }

    public void setYearsAsTeamBoss(int yearsAsTeamBoss) {
        this.yearsAsTeamBoss = yearsAsTeamBoss;
    }
}
