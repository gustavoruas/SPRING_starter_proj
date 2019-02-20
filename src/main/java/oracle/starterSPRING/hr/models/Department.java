package oracle.starterSPRING.hr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "DEPARTMENTS")
public class Department{

	/*
	 * table details DEPARTMENT_ID DEPARTMENT_NAME MANAGER_ID LOCATION_ID
	 */
    
	//https://www.mkyong.com/jpa/jpa-insert-oracle-sequences-example/
	@Id    //USING oracle sequence sequenceName = "DEPARTMENTS_SEQ"
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depart_seq" )
	@SequenceGenerator(sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1, name = "depart_seq")
	@Column(name = "DEPARTMENT_ID")
	private Long department_ID;
	

	@Column(name = "DEPARTMENT_NAME")
	private String department_Name;

	@Column(name = "MANAGER_ID")
	private Long manager_id;

	@Column(name = "LOCATION_ID")
	private Long location_id;
	
	//@OneToOne(fetch=FetchType.EAGER)
	//@MapsId
	//private Location loc;
	
	
    
	//Needs DEFAULT constructor
	public Department() {
		
	};
	
	public Department(Long department_ID, String department_Name, Long manager_id, Long location_id) {
		this.department_ID = department_ID;
		this.department_Name = department_Name;
		this.manager_id = manager_id;
		//this.location_id = location_id;
	}

	public Long getDepartment_ID() {
		return department_ID;
	}

	public void setDepartment_ID(Long department_ID) {
		this.department_ID = department_ID;
	}

	public String getDepartment_Name() {
		return department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	
	public Long getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	

}
