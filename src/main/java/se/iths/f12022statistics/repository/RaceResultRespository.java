package se.iths.f12022statistics.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.f12022statistics.entity.Race;
import se.iths.f12022statistics.entity.RaceResult;

public interface RaceResultRespository extends CrudRepository<RaceResult, Long> {
}
