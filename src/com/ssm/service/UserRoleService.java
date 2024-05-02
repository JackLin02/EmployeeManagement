package com.ssm.service;

import java.util.List;

import com.ssm.model.UserRole;

public interface UserRoleService {
	UserRole getUserRoleByeUidAndRid(Integer uid, Integer rid);

	List<UserRole> getAllUserRole();

	int deleteUserRole(UserRole userRole);

	int insertUserRole(UserRole userRole);

	int updateUserRole(UserRole userRole);
}
