package com.axis.leave.entity;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : EmployeeProject
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class EmployeeProject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 10 , unique = true)
	private int id;
	@Column(length = 10)
	private int empId;
	@Column(length = 20)
	private String empFirstName;
	@Column(length = 20)
	private String empLastName;
	@Column(length = 100)
	private String empProjects;

	
	public EmployeeProject() {
}


	public EmployeeProject(int id, int empId, String empFirstName, String empLastName, String empProjects) {
		super();
		this.id = id;
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empProjects = empProjects;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpFirstName() {
		return empFirstName;
	}


	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}


	public String getEmpLastName() {
		return empLastName;
	}


	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}


	public String getEmpProjects() {
		return empProjects;
	}


	public void setEmpProjects(String empProjects) {
		this.empProjects = empProjects;
	}


	@Override
	public String toString() {
		return "EmployeeProject [id=" + id + ", empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + ", empProjects=" + empProjects + "]";
	}

}
