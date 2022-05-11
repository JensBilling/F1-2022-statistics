package se.iths.f12022statistics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.f12022statistics.entity.RaceResult;

@Repository
public interface RaceResultRepository extends CrudRepository<RaceResult, Long> {
}
