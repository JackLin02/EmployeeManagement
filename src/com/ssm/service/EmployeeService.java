package com.ssm.service;import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssm.model.Employee;

public interface EmployeeService {
	/**
	 * Retrieving all employee data
	 * @return
	 */
	List<Employee> getAllEmployee();

	/**
	 * Retriving specify employee data through pageNum
	 * @param pageNum
	 * @return
	 */
	PageInfo<Employee> getAllEmployeePage(Integer pageIndex);

	Employee getEmployeeById(Integer id);

	// Inserting a new employee
	int insertEmployee(Employee emp);

	// Updating specified employee
	int updateEmployee(Employee emp);

	// Deleting specified employee
	int deleteEmployee(Employee emp);
}
