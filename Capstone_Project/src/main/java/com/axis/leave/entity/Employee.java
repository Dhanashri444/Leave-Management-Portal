package com.axis.leave.entity;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : Employee
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="emp_table")
public class Employee {
	
	private int empId;
	@Column(length = 20)
	private String empFirstName;
	@Column(length = 20)
	private String empLastName;
	@Column(length = 20)
	private String gender;
	@Column(length = 20)
	private String empRole;
	@Column(length = 15)
	private String empContact;
	@Column(length = 50)
	@Id
	private String empEmail;
	@Column(length = 20)
	private String empDob;
	@Column(length = 20)
	private String empJoining;
	@Column(length = 50)
	private String empUsername;
	@Column(length = 50)
	private String empPassword;
	private int sickLeave = 15;
	private int casualLeave = 15;
	private int personalLeave = 15;
	private int maternityLeave = 180;
	private int paternityLeave = 30;
	private int marriageLeave = 15;
	private int adoptionLeave = 30;
	
	
	public Employee() {
	
}


	public Employee(int empId, String empFirstName, String empLastName, String gender, String empRole,
			String empContact, String empEmail, String empDob, String empJoining, String empUsername,
			String empPassword, int sickLeave, int casualLeave, int personalLeave, int maternityLeave,
			int paternityLeave, int marriageLeave, int adoptionLeave) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.gender = gender;
		this.empRole = empRole;
		this.empContact = empContact;
		this.empEmail = empEmail;
		this.empDob = empDob;
		this.empJoining = empJoining;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.sickLeave = sickLeave;
		this.casualLeave = casualLeave;
		this.personalLeave = personalLeave;
		this.maternityLeave = maternityLeave;
		this.paternityLeave = paternityLeave;
		this.marriageLeave = marriageLeave;
		this.adoptionLeave = adoptionLeave;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmpRole() {
		return empRole;
	}


	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}


	public String getEmpContact() {
		return empContact;
	}


	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public String getEmpDob() {
		return empDob;
	}


	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}


	public String getEmpJoining() {
		return empJoining;
	}


	public void setEmpJoining(String empJoining) {
		this.empJoining = empJoining;
	}


	public String getEmpUsername() {
		return empUsername;
	}


	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}


	public String getEmpPassword() {
		return empPassword;
	}


	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}


	public int getSickLeave() {
		return sickLeave;
	}


	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}


	public int getCasualLeave() {
		return casualLeave;
	}


	public void setCasualLeave(int casualLeave) {
		this.casualLeave = casualLeave;
	}


	public int getPersonalLeave() {
		return personalLeave;
	}


	public void setPersonalLeave(int personalLeave) {
		this.personalLeave = personalLeave;
	}


	public int getMaternityLeave() {
		return maternityLeave;
	}


	public void setMaternityLeave(int maternityLeave) {
		this.maternityLeave = maternityLeave;
	}


	public int getPaternityLeave() {
		return paternityLeave;
	}


	public void setPaternityLeave(int paternityLeave) {
		this.paternityLeave = paternityLeave;
	}


	public int getMarriageLeave() {
		return marriageLeave;
	}


	public void setMarriageLeave(int marriageLeave) {
		this.marriageLeave = marriageLeave;
	}


	public int getAdoptionLeave() {
		return adoptionLeave;
	}


	public void setAdoptionLeave(int adoptionLeave) {
		this.adoptionLeave = adoptionLeave;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", gender=" + gender + ", empRole=" + empRole + ", empContact=" + empContact + ", empEmail="
				+ empEmail + ", empDob=" + empDob + ", empJoining=" + empJoining + ", empUsername=" + empUsername
				+ ", empPassword=" + empPassword + ", sickLeave=" + sickLeave + ", casualLeave=" + casualLeave
				+ ", personalLeave=" + personalLeave + ", maternityLeave=" + maternityLeave + ", paternityLeave="
				+ paternityLeave + ", marriageLeave=" + marriageLeave + ", adoptionLeave=" + adoptionLeave + "]";
	}
	
}
