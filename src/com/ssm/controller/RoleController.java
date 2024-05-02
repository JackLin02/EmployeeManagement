package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.ssm.model.Employee;
import com.ssm.model.Role;
import com.ssm.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;

	// Get all employees
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public String getRoleList(
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex, Model model) {

		// Getting employees's paging information
		PageInfo<Role> page = roleService.getAllRolePage(pageIndex);
		System.out.println("======" + page + "======");
		// Putting pageInfo into the shared request area
		model.addAttribute("page", page);
		// Transferring to "employee_list.html"
		return "pages/role_list";
	}

	// Get the specified employee
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	public String getRoleById(@PathVariable("id") Integer id, Model model) {
		Role role = roleService.getRoleById(id);
		model.addAttribute("role", role);
		return "pages/role_update";
	}

	// Insert a new employee
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public String insertRole(Role role) {
		roleService.insertRole(role);
		return "redirect:/roles";
	}

	// Update the specified employee
	@RequestMapping(value = "/role", method = RequestMethod.PUT)
	public String updateRole(Role role) {
		int result = roleService.updateRole(role);
		if(result > 0){
			return "redirect:/roles";
		}
		return "redirect:/dashboard";
	}

	// Delete the specified employee
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	public String deleteRole(@PathVariable("id") Integer id) {
		Role role = roleService.getRoleById(id);
		int result = roleService.deleteRole(role);
		if(result > 0){
			return "redirect:/roles";
		}
		return "redirect:/sign-in";
	}
}