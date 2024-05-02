package com.ssm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssm.model.Employee;
import com.ssm.model.Role;

public interface RoleService {
	Role getRoleById(Integer id);

	List<Role> getAllRole();

	/**
	 * Retriving specify role data through pageNum
	 * @param pageNum
	 * @return
	 */
	PageInfo<Role> getAllRolePage(Integer pageIndex);

	int deleteRole(Role role);

	int insertRole(Role role);

	int updateRole(Role role);

}
