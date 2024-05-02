package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.xdevapi.JsonArray;
import com.ssm.model.Employee;
import com.ssm.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Get all employees
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getEmployeeList(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex, Model model){

		// Getting employees's paging information
		PageInfo<Employee> page = employeeService.getAllEmployeePage(pageIndex);
		System.out.println("======"+page+"======");
		// Putting pageInfo into the shared request area
		model.addAttribute("page", page);
		// Transferring to "employee_list.html"
		return "pages/employee_list";
	}

	// Get the specified employee
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public String getEmployeeById(@PathVariable("id") Integer id, Model model){
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "pages/employee_update";
	}

	// Insert a new employee
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String insertEmployee(Employee employee){
		List<Employee> allEmployee = employeeService.getAllEmployee();
		int size = allEmployee.size();
		Employee lastEmp = allEmployee.get(size-1);
		Integer newEmpId = lastEmp.getEmployeeId() + 1;
		employee.setEmployeeId(newEmpId);
		employeeService.insertEmployee(employee);
		return "redirect:/employees";
	}

	// Update the specified employee
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public String updateEmployee(Employee employee){
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}

	// Delete the specified employee
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") Integer id){
		Employee employee = employeeService.getEmployeeById(id);
		employeeService.deleteEmployee(employee);
		return "redirect:/employees";
	}
}
