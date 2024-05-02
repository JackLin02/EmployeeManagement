package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.model.Role;

@Repository
public interface RoleDao {
	Role getRoleById(Integer id);

	List<Role> getAllRole();

	int deleteRole(Role role);

	int insertRole(Role role);

	int updateRole(Role role);
}
