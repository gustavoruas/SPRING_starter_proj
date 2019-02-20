package oracle.starterSPRING.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.starterSPRING.hr.services.DepartmentService;
import oracle.starterSPRING.hr.models.Department;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService dep) {
		this.departmentService = dep;
	}
	
	//Need requestMapping to crate link direction
	@RequestMapping("/")
	public String welcomeText() {
		return "Welcome to first attempt of SPRING TEST";
	}
	
	@RequestMapping("/list")
	public List<Department> getDepartments(){
		return departmentService.departmentList();
	}
	
	@RequestMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartment(id);
	}
	
	@RequestMapping("/add")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		return departmentService.deleteDepartment(id);
	}


}
