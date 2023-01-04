package com.axis.leave.controller;
/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Dhanashri kale
 * About this Page : LoginController
 */
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.axis.leave.entity.Employee;
import com.axis.leave.repo.IEmployeeRepo;
import com.axis.leave.service.HrServiceImpl;
@Controller
//@RequestMapping("/v1/login")
public class LoginController {
	

	@Autowired
	IEmployeeRepo emprepo;
	
	@Autowired
	HrServiceImpl service;
	
	@RequestMapping("/")
	public String welcome() {
		return "login";
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String Username, @RequestParam("password") String Password,
			HttpServletRequest request, HttpServletResponse response) {
		if (Username != null && Password != null) {
			boolean isValid = service.checkCrendential(Username, Password);
			if (isValid) {
				Optional<Employee> employee = emprepo.findById(Username);
				String first = employee.get().getEmpFirstName();
				String role = employee.get().getEmpRole();
				int empId = employee.get().getEmpId();
				String last = employee.get().getEmpLastName();
				String email = employee.get().getEmpEmail();
				ModelAndView mv = new ModelAndView();
				HttpSession session = request.getSession();
				session.setAttribute("empFirst", first);
				session.setAttribute("employee", employee);
				session.setAttribute("empLast", last);
				session.setAttribute("empId", empId);
				session.setAttribute("empEmail", email);
				if (role.equals("Hr")) {
					return new ModelAndView("redirect:/hr");
				} else if (role.equals("Employee")) {
					return new ModelAndView("redirect:/Employee");
				} else if (role.equals("Manager")) {
					return new ModelAndView("redirect:/Manager");
				} else if (role.equals("Senior Manager")) {
					return new ModelAndView("redirect:/SeniorManager");
				} else {
					return new ModelAndView("redirect:/AccessDenied");
				}
			} else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
	}

	@RequestMapping("/hr")
	public String hrLogin() {
		return "adminDashboard";
	}

	@RequestMapping("/Employee")
	public String empLogin() {
		return "employeeDashboard";
	}

	@RequestMapping("/Manager")
	public String mnLogin() {
		return "managerDashboard";
	}


	// for logout
		@RequestMapping("/Logout")
		public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			session.invalidate();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
}
