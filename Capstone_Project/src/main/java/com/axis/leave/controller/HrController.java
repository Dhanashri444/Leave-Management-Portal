package com.axis.leave.controller;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : HrController
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.axis.leave.entity.HrLeave;
import com.axis.leave.repo.IEmployeeLeaveRepo;
import com.axis.leave.repo.IEmployeeProjectRepo;
import com.axis.leave.repo.IEmployeeRepo;
import com.axis.leave.repo.IHolidayRepo;
import com.axis.leave.repo.IHrLeaveRepo;
import com.axis.leave.service.HrServiceImpl;

@Controller
//@RequestMapping("/v1/hr")
public class HrController {

	@Autowired
	HrServiceImpl service;
	
	@Autowired
	IEmployeeRepo emprepo;
	
	@Autowired
	IHrLeaveRepo hrleaveRepo;
	
	@Autowired
	IEmployeeLeaveRepo empleaverepo;
	
	@Autowired
	IEmployeeProjectRepo projectRepo;
	
	@Autowired
	IHolidayRepo holidayRepo;
	
	
	@RequestMapping("/AddEmployeeForm")
	public ModelAndView getId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = service.autoId();
		ModelAndView mv = new ModelAndView();
		mv.addObject("newEmpId", id);
		mv.setViewName("addEmployee");
		return mv;
	}

	@RequestMapping("/addEmployee")
	public ModelAndView addEmp(Employee employee) {
		emprepo.save(employee);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/employeeList");
	}

	@RequestMapping("/employeeList")
	public ModelAndView showEmp() {
		ModelAndView mv = new ModelAndView();
		List<Employee> EmployeeList = emprepo.findAll();
		mv.addObject("EmployeeList", EmployeeList);
		mv.setViewName("manageUsers");
		return mv;
	}

	// for edit the Employee Details
	@RequestMapping("/edit")
	public String editEmployee(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee newEmployee = emprepo.getReferenceById(email);
		request.setAttribute("NewDetails", newEmployee);
		return "EditEmpDetails";
	}

	// for saving the edited details
	@RequestMapping("/UpdateDetails")
	public ModelAndView changeDetails(Employee employee) {
		Employee oldData = emprepo.getReferenceById(employee.getEmpEmail());
		emprepo.delete(oldData);
		emprepo.save(employee);
		return new ModelAndView("redirect:/employeeList");
	}

	// for deleting the Employee details
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		String email = request.getParameter("email");
		emprepo.deleteById(email);
		return new ModelAndView("redirect:/employeeList");
	}

	// for apply leave
	@RequestMapping("/hrApplyLeave")
	public ModelAndView leave(HrLeave hrLeave, @RequestParam("empId") int empId,
			@RequestParam("period") int period, @RequestParam("leaveType") String leaveType) throws SQLException {
		hrleaveRepo.save(hrLeave);
		try {
			service.subtractLeave(leaveType, period, empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/hrLeaveList");
	}

	// for showing the hr Leave status
	@RequestMapping("/hrLeaveList")
	public ModelAndView showStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("empId");
		List<HrLeave> leaveList = hrleaveRepo.findByEmployeeId(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("hrLeaveList", leaveList);
		mv.setViewName("leaveStatus");
		return mv;
	}

	
	// for showing the all leave request
		@RequestMapping("/ManageLeaves")
		public ModelAndView showLeaves() {
			ModelAndView mv = new ModelAndView();
			List<EmployeeLeave> leavesList = empleaverepo.findAll();
			mv.addObject("empLeavesList", leavesList);
			mv.setViewName("hrManageLeave");
			return mv;

		}
	

	// for approval
	@RequestMapping("/editAction")
	public String approveLeave(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeLeave applyLeave = empleaverepo.getReferenceById(id);
		request.setAttribute("EmpApplyLeave", applyLeave);
		return "hrLeaveAction";
	}

	// updating the status
	@RequestMapping("/UpdateStatus")
	public ModelAndView update(EmployeeLeave leave) {
		EmployeeLeave oldData = empleaverepo.getReferenceById(leave.getId());
		empleaverepo.delete(oldData);
		empleaverepo.save(leave);
		return new ModelAndView("redirect:/ManageLeaves");
	}

	
	// for check leave balance
	@RequestMapping("/CheckLeaveBalance")
	public String leaveBalance(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee empList = emprepo.getReferenceById(email);
		request.setAttribute("empLeaveList", empList);
		return "hrLeaveBalance";
	}

	@RequestMapping("/hrMyProfile")
	public String myProfile(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee empdetails = emprepo.getReferenceById(email);
		request.setAttribute("empDetails", empdetails);
		return "hrProfile";
	}

	// for editing the username and password
	@RequestMapping("/hrEditMyProfile")
	public String editProfile(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee empdetails = emprepo.getReferenceById(email);
		request.setAttribute("empDetails", empdetails);
		return "hrEditMyProfile";
	}

	// for updating the username and pssword
	@RequestMapping("/hrUpdateProfile")
	public ModelAndView update(Employee employee) {
		Employee oldData = emprepo.getReferenceById(employee.getEmpEmail());
		emprepo.delete(oldData);
		emprepo.save(employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminDashboard");
		return mv;
	}

	// for adding the project details
	@RequestMapping("/addProject")
	public String addProject(HttpServletRequest request) {
		String email = request.getParameter("email");
		Employee employee = emprepo.getReferenceById(email);
		request.setAttribute("empDetail", employee);
		return "hrAddProject";
	}

	// for submitting the project details
	@RequestMapping("/saveProject")
	public ModelAndView Project(EmployeeProject project) {
		projectRepo.save(project);
		return new ModelAndView("redirect:/showProjectList");
	}

	// for showing the project Details
	@RequestMapping("/showProjectList")
	public ModelAndView showProject() {
		List<EmployeeProject> projectDetails = projectRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("projectDetails", projectDetails);
		mv.setViewName("projectDetails");
		return mv;
	}
	
	// for deleting the project details
	@RequestMapping("/deleteProject")
	public ModelAndView deleteProject(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		projectRepo.deleteById(id);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/showProjectList");
	}
	
	@RequestMapping("/addHoliday")
	public ModelAndView add(Holiday holiday) {
		holidayRepo.save(holiday);
		return new ModelAndView("redirect:/hrShowHoliday"); 
	}
	
	@RequestMapping("/hrShowHoliday")
	public ModelAndView show() {
		List<Holiday> holiday = holidayRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("holidayList", holiday);
		mv.setViewName("hrShowHoliday");
		return mv;
	}
	@RequestMapping("/deleteHoliday")
	public ModelAndView delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		holidayRepo.deleteById(id);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/hrShowHoliday");
	}

}
