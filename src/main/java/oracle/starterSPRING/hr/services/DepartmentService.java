package oracle.starterSPRING.hr.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import oracle.starterSPRING.hr.models.Department;
import oracle.starterSPRING.hr.repositories.DepartmentRepository;

@Service
public class DepartmentService implements DepartmentServInterface {

	private DepartmentRepository departmentRepository;
	
	
	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> departmentList() {
		// TODO Auto-generated method stub
		
		return departmentRepository.findAll();
	}
	
	@Override
	public Department getDepartment(Long id) {
		
		return departmentRepository.getOne(id);
	}
	
	@Override
	public Department saveDepartment(Department department) {
		if(departmentRepository.existsById(department.getDepartment_ID())) {
		  return departmentRepository.save(department);
		}else {
			
			Department dep = department;						
			return departmentRepository.save(dep);
		}
		
	}

	@Override
	public String deleteDepartment(Long id) {		
		
		try {
			departmentRepository.deleteById(id);
			return "{Department deleted successfully.}";
		}catch(JpaSystemException e) {
			return "Unable to delete department: = " + id.toString() + "<br>"
			       + e.getMessage();
		}		
		
	}


	
	

}
