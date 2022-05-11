package se.iths.f12022statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import se.iths.f12022statistics.entity.*;
import se.iths.f12022statistics.repository.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class F12022StatisticsApplication {


    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RaceRepository raceRepository;

    public F12022StatisticsApplication(TeamRepository teamRepository, UserRepository userRepository, RoleRepository roleRepository, RaceRepository raceRepository, RaceResultRepository raceResultRespository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.raceRepository = raceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(F12022StatisticsApplication.class, args);


    }


    @EventListener(ApplicationReadyEvent.class)
    // Generate data at start up
    // Method to autofill database with data if empty
    public void fillDatabase() {
        //RedBull
        teamRepository.save(new Team("RedBull Racing", "RedBull power unit",
                Stream.of(new Driver("MAX VERSTAPPEN", 23), new Driver("SERGIO PEREZ", 32)).collect(Collectors.toList()),
                new Boss("CHRISTIAN HORNER", 48, 17)));
        //Mercedes
        teamRepository.save(new Team("Mercedes", "Mercedes powertrains",
                Stream.of(new Driver("GEORGE RUSSELL", 24), new Driver("LEWIS HAMILTON", 37)).collect(Collectors.toList()),
                new Boss("TOTO WOLFF", 50, 9)));
        //McLaren
        teamRepository.save(new Team("McLaren Racing", "Mercedes powertrains",
                Stream.of(new Driver("LANDO NORRIS", 22), new Driver("DANIEL RICCIARDO", 32)).collect(Collectors.toList()),
                new Boss("ZAK BROWN", 50, 5)));
        //Ferrari
        teamRepository.save(new Team("Ferrari", "Ferrari power unit",
                Stream.of(new Driver("CARLOS SAINZ JR", 24), new Driver("CHARLES LECLERC", 24)).collect(Collectors.toList()),
                new Boss("MATTIA BINOTTO", 52, 3)));
        //Haas
        teamRepository.save(new Team("Haas F1 Team", "Ferrari power unit",
                Stream.of(new Driver("KEVIN MAGNUSSEN", 29), new Driver("MICK SCHUMACHER ", 23)).collect(Collectors.toList()),
                new Boss("GÜNTHER STEINER", 57, 8)));
        //Aston Martin
        teamRepository.save(new Team("Aston Martin", "Mercedes powertrains",
                Stream.of(new Driver("SEBASTIAN VETTEL", 34), new Driver("LANCE STROLL", 23)).collect(Collectors.toList()),
                new Boss("MIKE KRACK", 50, 7)));
        //Alpha Tauri
        teamRepository.save(new Team("Alpha Tauri", "RedBull power unit",
                Stream.of(new Driver("PIERRE GASLY", 26), new Driver("YUKI TSUNODA", 21)).collect(Collectors.toList()),
                new Boss("FRANZ TOST", 66, 16)));
        //Alfa Romeo
        teamRepository.save(new Team("Alpha Romeo", "Ferrari power unit",
                Stream.of(new Driver("VALTTERI BOTTAS", 32), new Driver("GUANYU ZHOU", 22)).collect(Collectors.toList()),
                new Boss("FRÉDÉRIC VASSEUR", 53, 5)));
        //Williams
        teamRepository.save(new Team("Williams Racing", "Mercedes powertrains",
                Stream.of(new Driver("ALEXANDER ALBON", 26), new Driver("NICHOLAS LATIFI", 26)).collect(Collectors.toList()),
                new Boss("JOST CAPITO", 63, 1)));
        //Alpine
        teamRepository.save(new Team("Alpine F1", "Renault F1",
                Stream.of(new Driver("ESTEBAN OCON", 25), new Driver("FERNANDO ALONSO", 40)).collect(Collectors.toList()),
                new Boss("OTMAR SZAFNAUER", 63, 0)));

        // Adds user accounts and roles
        User userUser = new User("User user", "user", "user@mail.com", "password");
        User adminUser = new User("Admin user", "admin", "admin@mail.com", "password");
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        Set<Role> userRoleSet = new HashSet<>();
        Set<Role> adminRoleSet = new HashSet<>();

        roleRepository.save(userRole);
        roleRepository.save(adminRole);
        userRepository.save(userUser);
        userRepository.save(adminUser);

        userRoleSet.add(userRole);
        adminRoleSet.add(userRole);
        adminRoleSet.add(adminRole);

        userUser.setRoles(userRoleSet);
        adminUser.setRoles(adminRoleSet);

        userRepository.save(userUser);
        userRepository.save(adminUser);

        // add race and results
        raceRepository.save(new Race("Bahrain", 53.3, 16L, Stream.of(
                        new RaceResult(16L, 1L),
                        new RaceResult(15L, 2L),
                        new RaceResult(8L, 3L),
                        new RaceResult(7L, 4L),
                        new RaceResult(19L, 5L),
                        new RaceResult(31L, 6L),
                        new RaceResult(39L, 7L),
                        new RaceResult(28L, 8L),
                        new RaceResult(40L, 9L),
                        new RaceResult(32L, 10L),
                        new RaceResult(20L, 11L),
                        new RaceResult(24L, 12L),
                        new RaceResult(27L, 13L),
                        new RaceResult(12L, 14L),
                        new RaceResult(11L, 15L),
                        new RaceResult(36L, 16L),
                        new RaceResult(4L, 17L),
                        new RaceResult(3L, 18L),
                        new RaceResult(27L, 19L))
                .collect(Collectors.toList())));

    }


}
