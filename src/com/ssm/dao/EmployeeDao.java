package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.model.Employee;

@Repository
public interface EmployeeDao {
	// Retrieving all employees
	List<Employee> getAllEmployee();

	// Retrieving specified employee by employee id
	Employee getEmployeeById(@Param("id") Integer id);

	// Inserting a new employee
	int insertEmployee(Employee emp);

	// Updating specified employee
	int updateEmployee(Employee emp);

	// Deleting specified employee
	int deleteEmployee(Employee emp);
}
