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

   /* public F12022StatisticsApplication(TeamService teamService) {
        this.teamService = teamService;
    }
*/
    public static void main(String[] args) {
        SpringApplication.run(F12022StatisticsApplication.class, args);
    }



    /* Method to autofill database with data if empty
    private final TeamService teamService;
+
    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase(){

        Boss christianHorner = new Boss("Christian Horner",
                48,
                17);



        Driver maxVerstappen = new Driver("Max Verstappen",
                24,
                )




    }
*/
}
