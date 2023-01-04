package com.axis.leave.service;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : IEmployeeService
 */
import org.springframework.stereotype.Service;

@Service
public interface IEmployeeService {

	public boolean subtractLeave(String leaveType, int period, int empId);
	
}
