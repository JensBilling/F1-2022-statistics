package se.iths.f12022statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.entity.Driver;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.service.TeamService;

import java.util.ArrayList;

@SpringBootApplication
public class F12022StatisticsApplication {



    public static void main(String[] args) {
        SpringApplication.run(F12022StatisticsApplication.class, args);
    }






}
