package se.iths.f12022statistics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.f12022statistics.entity.Race;

@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {
}
