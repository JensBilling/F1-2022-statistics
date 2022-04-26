package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.repository.TeamRepository;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public  void createNewTeam(Team team){
        teamRepository.save(team);
    }
}
