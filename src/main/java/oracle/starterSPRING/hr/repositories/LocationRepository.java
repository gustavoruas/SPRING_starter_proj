package oracle.starterSPRING.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oracle.starterSPRING.hr.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
