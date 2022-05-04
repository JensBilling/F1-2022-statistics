package se.iths.f12022statistics.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.repository.BossRepository;

@Service
public class BossService {

    private final BossRepository bossRepository;

    public BossService(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    public Iterable<Boss> getAllBosses() {
        return bossRepository.findAll();
    }
}
