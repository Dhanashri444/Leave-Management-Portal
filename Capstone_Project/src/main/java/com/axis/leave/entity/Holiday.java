package com.axis.leave.entity;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : Holiday
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Holiday {
	@Id
	@Column(length = 5, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(length = 20)
	private String holidayDate;
	@Column(length = 20)
	private String month;
	@Column(length = 20)
	private String year;
	@Column(length = 50)
	private String holidays;
	
	
	public Holiday() {
	
}


	public Holiday(int id, String holidayDate, String month, String year, String holidays) {
		super();
		this.id = id;
		this.holidayDate = holidayDate;
		this.month = month;
		this.year = year;
		this.holidays = holidays;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHolidayDate() {
		return holidayDate;
	}


	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getHolidays() {
		return holidays;
	}


	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}


	@Override
	public String toString() {
		return "Holiday [id=" + id + ", holidayDate=" + holidayDate + ", month=" + month + ", year=" + year
				+ ", holidays=" + holidays + "]";
	}
	
}