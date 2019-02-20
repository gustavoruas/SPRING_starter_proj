package oracle.starterSPRING.hr.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import oracle.starterSPRING.hr.models.Department;

public interface DepartmentServInterface {

		
	List<Department> departmentList();

	Department getDepartment(Long id);

	Department saveDepartment(Department department);
	
	String deleteDepartment(Long id);
	
	
}
