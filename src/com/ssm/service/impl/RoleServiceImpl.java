package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.RoleDao;
import com.ssm.model.Employee;
import com.ssm.model.Role;
import com.ssm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public Role getRoleById(Integer id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getAllRole() {
		return roleDao.getAllRole();
	}

	@Override
	public PageInfo<Role> getAllRolePage(Integer pageIndex) {
		// Opening paging feature, startPage(startPageIndex, perPageSize)
		PageHelper.startPage(pageIndex, 10);
		// Retrieving all employees information
		List<Role> roles = this.getAllRole();
		// Getting the paging data, PageInfo<>(allData, bufferPages)
		PageInfo<Role> pageInfo = new PageInfo<>(roles, 6);
		return pageInfo;
	}

	@Override
	public int deleteRole(Role role) {
		return roleDao.deleteRole(role);
	}

	@Override
	public int insertRole(Role role) {
		return roleDao.insertRole(role);
	}

	@Override
	public int updateRole(Role role) {
		return roleDao.updateRole(role);
	}

}
