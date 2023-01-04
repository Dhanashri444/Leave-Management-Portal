package com.axis.leave.controller;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : ManagerController
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

import com.axis.leave.entity.ApplyLeaveManager;
import com.axis.leave.entity.Employee;
import com.axis.leave.entity.EmployeeLeave;
import com.axis.leave.entity.EmployeeProject;
import com.axis.leave.entity.Holiday;
import com.axis.leave.repo.IEmployeeLeaveRepo;
import com.axis.leave.repo.IEmployeeProjectRepo;
import com.axis.leave.repo.IEmployeeRepo;
import com.axis.leave.repo.IHolidayRepo;
import com.axis.leave.repo.ManagerLeaveRepository;
import com.axis.leave.service.ManagerService;


@Controller
public class ManagerController {

	@Autowired
	ManagerLeaveRepository managerLeaveRepo;

	@Autowired
	IEmployeeLeaveRepo  empLeaveRepo;

	@Autowired
	IEmployeeRepo empRepo;

	@Autowired
	ManagerService service;
	
	@Autowired
	IEmployeeProjectRepo projectRepo;
	
	@Autowired
	IHolidayRepo holidayRepo;

	// for apply leave
	@RequestMapping("/managerApplyLeave")
	public ModelAndView leave(ApplyLeaveManager Leave, @RequestParam("empId") int empId,
			@RequestParam("period") int period, @RequestParam("leaveType") String leaveType) throws SQLException {
		managerLeaveRepo.save(Leave);
		try {
			service.subtractLeave(leaveType, period, empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/managerLeaveList");
	}

	// for showing the hr Leave status
	@RequestMapping("/managerLeaveList")
	public ModelAndView showStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("empId");
		List<ApplyLeaveManager> leaveList = managerLeaveRepo.findByEmployeeId(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("managerLeaveList", leaveList);
		mv.setViewName("managerCheckStatus");
		return mv;
	}

	// for showing the all leave request
	@RequestMapping("/managerManageLeaves")
	public ModelAndView showLeaves() {
		ModelAndView mv = new ModelAndView();
		List<EmployeeLeave> leavesList = empLeaveRepo.findAll();
		mv.addObject("empLeavesList", leavesList);
		mv.setViewName("managerManageLeave");
		return mv;

	}

	// for approval
	@RequestMapping("/managereditAction")
	public String approveLeave(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeLeave applyLeave = empLeaveRepo.getReferenceById(id);
		request.setAttribute("EmpApplyLeave", applyLeave);
		return "managerLeaveAction";
	}

	// updating the status
	@RequestMapping("/managerUpdateStatus")
	public ModelAndView update(EmployeeLeave leave) {
		EmployeeLeave oldData = empLeaveRepo.getReferenceById(leave.getId());
		empLeaveRepo.delete(oldData);
		empLeaveRepo.save(leave);
		return new ModelAndView("redirect:/managerManageLeaves");
	}

	// for check leave balance
	@RequestMapping("/managerCheckLeaveBalance")
	public String leaveBalance(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee empList = empRepo.getReferenceById(email);
		request.setAttribute("empLeaveList", empList);
		return "managerCheckLeaveBalance";
	}
	
	@RequestMapping("/managerMyProfile")
	public String myProfile(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee empdetails = empRepo.getReferenceById(email);
		request.setAttribute("empDetails", empdetails);
		return "managerMyProfile";
	}
	
	// for editing the username and password
	@RequestMapping("/managerEditMyProfile")
	public String editProfile(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee empdetails = empRepo.getReferenceById(email);
		request.setAttribute("empDetails", empdetails);
		return "managerEditMyProfile";
	}

	// for updating the username and pssword
	@RequestMapping("/managerUpdateProfile")
	public ModelAndView update(Employee employee) {
		Employee oldData = empRepo.getReferenceById(employee.getEmpEmail());
		empRepo.delete(oldData);
		empRepo.save(employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerDashboard");
		return mv;
	}
	
	@RequestMapping("/managerShowProject")
	public ModelAndView showProject(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		List<EmployeeProject> project = projectRepo.findByEmpId(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("projectDetails" , project);
		mv.setViewName("managerShowProject");
		return mv;
	}
	
	@RequestMapping("/managerShowHoliday")
	public ModelAndView showHoliday(HttpServletRequest request) {
		List<Holiday> project = holidayRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("holidayList" , project);
		mv.setViewName("managerShowHoliday");
		return mv;
	}
}
