package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.EmployeeDao;
import com.ssm.model.Employee;
import com.ssm.service.EmployeeService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public int insertEmployee(Employee emp) {
		return employeeDao.insertEmployee(emp);
	}

	@Override
	public int updateEmployee(Employee emp) {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public int deleteEmployee(Employee emp) {
		return employeeDao.deleteEmployee(emp);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public PageInfo<Employee> getAllEmployeePage(Integer pageIndex) {
		// Opening paging feature, startPage(startPageIndex, perPageSize)
		PageHelper.startPage(pageIndex, 10);
		// Retrieving all employees information
		List<Employee> employees = this.getAllEmployee();
		// Getting the paging data, PageInfo<>(allData, bufferPages)
		PageInfo<Employee> pageInfo = new PageInfo<>(employees, 6);
		return pageInfo;
	}
}
