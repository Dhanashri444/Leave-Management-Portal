package com.axis.leave.service;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : HrServiceImpl
 */
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.leave.entity.Employee;
import com.axis.leave.repo.IEmployeeRepo;
@Service
public class HrServiceImpl implements IHrService {
	
	@Autowired
	IEmployeeRepo emprepo;

	@Override
	public boolean checkCrendential(String Username, String Password) {
		Optional<Employee> user = emprepo.findById(Username);
		String password = user.get().getEmpPassword();
		String username = user.get().getEmpUsername();
		if (password.equals(Password) && username.equals(Username))
			return true;
		else
		return false;
	}

	@Override
	public int autoId() {
		int empid = emprepo.findMaxValue();
		return empid = empid + 1 ;		
	}

	@Override
	public boolean subtractLeave(String leaveType, int period, int empId) {
		if(leaveType.equals("sickLeave")) {
			emprepo.updateSickLeave(period, empId);
			return true;
		}else if(leaveType.equals("casualLeave")) {
			emprepo.updateCasualLeave(period, empId);
			return true;
		}else if(leaveType.equals("personalLeave")) {
			emprepo.updatePersonalLeave(period, empId);
			return true;
		}else if(leaveType.equals("maternityLeave")) {
			emprepo.updateMaternityLeave(period, empId);
			return true;
		}else if(leaveType.equals("paternityLeave")) {
			emprepo.updatePaternityLeave(period, empId);
			return true;
		}else if(leaveType.equals("marriageLeave")) {
			emprepo.updateMarriageLeave(period, empId);
			return true;
		}else if(leaveType.equals("adoptionLeave")) {
			emprepo.updateAdoptionLeave(period, empId);
			return true;
		}else 
			
			return false;
	}
	}


