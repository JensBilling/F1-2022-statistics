package se.iths.f12022statistics.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.repository.BossRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class BossService {

    private final BossRepository bossRepository;

    public BossService(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    public Iterable<Boss> getAllBosses() {
        return bossRepository.findAll();
    }

    public Boss getBossById(Long id) {
        Boss foundBoss = bossRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return foundBoss;
    }

    public Boss addNewBoss(Boss boss) {
        bossRepository.save(boss);
        return boss;
    }

    public void deleteBossFromDatabase(Long id) {
        Boss foundBoss = bossRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        bossRepository.delete(foundBoss);
    }
}
