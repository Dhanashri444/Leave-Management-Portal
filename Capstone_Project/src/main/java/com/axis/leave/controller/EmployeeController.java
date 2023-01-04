package com.axis.leave.controller;

/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : Employee Controller
 */

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.axis.leave.entity.Employee;
import com.axis.leave.entity.EmployeeLeave;
import com.axis.leave.entity.EmployeeProject;
import com.axis.leave.entity.Holiday;
import com.axis.leave.repo.IEmployeeLeaveRepo;
import com.axis.leave.repo.IEmployeeProjectRepo;
import com.axis.leave.repo.IEmployeeRepo;
import com.axis.leave.repo.IHolidayRepo;
import com.axis.leave.service.EmployeeServiceImpl;
@Controller
//@RequestMapping("/v1/emp")
public class EmployeeController {

	@Autowired
	IEmployeeLeaveRepo empleaverepo;
	
	@Autowired
	EmployeeServiceImpl service;
	
	@Autowired
	IEmployeeRepo emprepo;
	
	@Autowired
	IHolidayRepo holidayrepo;
	
	@Autowired
	IEmployeeProjectRepo projectRepo;
	
	

	// for apply leave
	@RequestMapping("/empApplyLeave")
	public ModelAndView leave(EmployeeLeave empLeave , @RequestParam("empId") int empId , @RequestParam("period") int period , @RequestParam("leaveType") String leaveType) throws SQLException  {
		empleaverepo.save(empLeave);
		try {
			service.subtractLeave(leaveType, period, empId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/empLeaveList");
	}

	// for showing the hr Leave status
	@RequestMapping("/empLeaveList")
	public ModelAndView showStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("empId");
		List<EmployeeLeave> leaveList = empleaverepo.findByEmployeeId(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empLeaveList", leaveList);
		mv.setViewName("employeeCheckStatus");
		return mv;
	}
	
	//for check leave balance
		@RequestMapping("/empCheckLeaveBalance")
		public String leaveBalance(HttpServletRequest request) {
			String email = request.getParameter("email");
			Employee empList = emprepo.getReferenceById(email);
			request.setAttribute("empLeaveList", empList);
			return "employeeCheckLeaveBalance";
		}
		
		@RequestMapping("/employeeMyProfile")
		public String myProfile(HttpServletRequest request) {
			String email = request.getParameter("email");
			Employee empdetails = emprepo.getReferenceById(email);
			request.setAttribute("empDetails", empdetails);
			return "employeeMyProfile";
		}
		
		// for editing the username and password
		@RequestMapping("/employeeEditMyProfile")
		public String editProfile(HttpServletRequest request) {
			String email = request.getParameter("email");
			Employee empdetails = emprepo.getReferenceById(email);
			request.setAttribute("empDetails", empdetails);
			return "employeeEditMyProfile";
		}

		// for updating the username and pssword
		@RequestMapping("/employeeUpdateProfile")
		public ModelAndView update(Employee employee) {
			Employee oldData = emprepo.getReferenceById(employee.getEmpEmail());
			emprepo.delete(oldData);
			emprepo.save(employee);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("employeeDashboard");
			return mv;
		}
		
		@RequestMapping("/employeeShowProject")
		public ModelAndView showProject(HttpServletRequest request) {
			HttpSession session = request.getSession();
			int empId = (int) session.getAttribute("empId");
			List<EmployeeProject> project = projectRepo.findByEmpId(empId);
			ModelAndView mv = new ModelAndView();
			mv.addObject("projectDetails" , project);
			mv.setViewName("employeeShowProject");
			return mv;
		}
		
		@RequestMapping("/employeeShowHoliday")
		public ModelAndView showHoliday(HttpServletRequest request) {
			List<Holiday> project = holidayrepo.findAll();
			ModelAndView mv = new ModelAndView();
			mv.addObject("holidayList" , project);
			mv.setViewName("employeeShowHoliday");
			return mv;
		}
		
		
	
	
}
