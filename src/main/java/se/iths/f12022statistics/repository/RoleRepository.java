package se.iths.f12022statistics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.f12022statistics.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
