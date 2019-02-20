package oracle.starterSPRING.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oracle.starterSPRING.hr.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
