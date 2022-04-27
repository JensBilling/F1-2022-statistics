package se.iths.f12022statistics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.repository.*;
import se.iths.f12022statistics.service.TeamService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class F12022StatisticsApplication {


    private TeamRepository teamRepository;

    public F12022StatisticsApplication(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(F12022StatisticsApplication.class, args);


    }
    @EventListener(ApplicationReadyEvent.class)
    // Generate data at start up
    // Method to autofill database with data if empty
    public void fillDatabase(){




    }





}
