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

@SpringBootApplication
public class F12022StatisticsApplication {

    /* public F12022StatisticsApplication(TeamService teamService) {
         this.teamService = teamService;
     }
 */
    public static void main(String[] args) {
        SpringApplication.run(F12022StatisticsApplication.class, args);
    }

    // Generate data at start up
    @Bean
    public CommandLineRunner fillDb(DriverRepository driverRepository,
                                    RaceRepository raceRepository,
                                    TeamRepository teamRepository,
                                    BossRepository bossRepository,
                                    RoleRepository roleRepository,
                                    UserRepository userRepository) {
        return (args) -> {
            driverRepository.save(new Driver("MAX VERSTAPPEN", 23));
            driverRepository.save(new Driver("SERGIO PEREZ", 23));
            driverRepository.save(new Driver("GEORGE RUSSELL", 23));
            driverRepository.save(new Driver("LEWIS HAMILTON", 23));
            driverRepository.save(new Driver("VALTTERI BOTTAS", 23));
            driverRepository.save(new Driver("GIANIOU ZHOU", 23));
            driverRepository.save(new Driver("SEBASTIAN VETTEL", 23));
            driverRepository.save(new Driver("LANCE STROLL", 23));
            driverRepository.save(new Driver("CARLOS SAINZ", 23));
            driverRepository.save(new Driver("CHARLES LECLERC", 23));
            driverRepository.save(new Driver("ALEXANDER ALBON", 23));
            driverRepository.save(new Driver("NIKOLAS LATIFI", 23));
            driverRepository.save(new Driver("DANIEL RICCIARDO", 23));
            driverRepository.save(new Driver("LANDO NORRIS", 23));
            driverRepository.save(new Driver("MICK SCHUMACHER", 23));
            driverRepository.save(new Driver("KEVIN MAGNUSSEN", 23));
            driverRepository.save(new Driver("YUKI TSUNODA", 23));
            driverRepository.save(new Driver("PIERRE GASLY", 23));
            driverRepository.save(new Driver("ESTEBAN OCON", 23));

            List<Driver> redBullDrivers = new ArrayList<>();
            Driver rbd1 = new Driver("MAX VERSTAPPEN", 23);
            Driver rbd2 = new Driver("SERGIO PEREZ", 23);
            redBullDrivers.add(rbd1);
            redBullDrivers.add(rbd2);





            teamRepository.save(new Team("RedBull Racing", "RedBull power unit",
                    redBullDrivers, new Boss("Christian Horner", 50, 7 )));


        };
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
