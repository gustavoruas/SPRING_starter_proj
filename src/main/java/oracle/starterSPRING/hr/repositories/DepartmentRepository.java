package oracle.starterSPRING.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import oracle.starterSPRING.hr.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	

}
