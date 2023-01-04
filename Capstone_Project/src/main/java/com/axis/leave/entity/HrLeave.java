package com.axis.leave.entity;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : HrLeave
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "hrleaves")
public class HrLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(length = 10)
	private int empId;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastname;
	@Column(length = 30)
	private String leaveType;
	@Column(length = 20)
	private String startDate;
	@Column(length = 20)
	private String endDate;
	@Column(length = 10)
	private int period;
	@Column(length = 100)
	private String leaveComment;
	@Column(length = 20)
	private String status = "Pending";
	
	
	public HrLeave() {
	
}


	public HrLeave(int id, int empId, String firstName, String lastname, String leaveType, String startDate,
			String endDate, int period, String leaveComment, String status) {
		super();
		this.id = id;
		this.empId = empId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.period = period;
		this.leaveComment = leaveComment;
		this.status = status;
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getLeaveType() {
		return leaveType;
	}


	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public String getLeaveComment() {
		return leaveComment;
	}


	public void setLeaveComment(String leaveComment) {
		this.leaveComment = leaveComment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "HrLeave [id=" + id + ", empId=" + empId + ", firstName=" + firstName + ", lastname=" + lastname
				+ ", leaveType=" + leaveType + ", startDate=" + startDate + ", endDate=" + endDate + ", period="
				+ period + ", leaveComment=" + leaveComment + ", status=" + status + "]";
	}
	
	
}