package se.iths.f12022statistics.service;


import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.repository.BossRepository;
import se.iths.f12022statistics.responsehandling.EntityAlreadyExistsException;
import se.iths.f12022statistics.responsehandling.NotFoundInDatabaseException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BossService {

    private final BossRepository bossRepository;

    public BossService(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    public Iterable<Boss> getAllBosses() {
        return bossRepository.findAll();
    }

    public Optional<Boss> getBossById(Long id) {
        Optional<Boss> foundBoss = retrieveBossFromDB(id);
        return foundBoss;
    }

    public Boss addNewBoss(Boss boss) {
        Iterable<Boss> foundBoss = bossRepository.findAll();
        for (Boss dbBoss : foundBoss) {
            if (dbBoss.getName().equals(boss.getName())) {
                throw new EntityAlreadyExistsException("That team boss already exists in the database.");
            }
        }
        bossRepository.save(boss);
        return boss;
    }

    public void deleteBossFromDatabase(Long id) {
        Optional<Boss> foundBoss = retrieveBossFromDB(id);
        bossRepository.delete(foundBoss.get());
    }

    private Optional<Boss> retrieveBossFromDB(Long id) {
        Optional<Boss> foundBoss = bossRepository.findById(id);
        if (foundBoss.isEmpty()) {
            throw new NotFoundInDatabaseException("Boss with that id was not found in the database.");
        }
        return foundBoss;
    }
}
