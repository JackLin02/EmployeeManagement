package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.model.UserRole;

@Repository
public interface UserRoleDao {
	UserRole getUserRoleByeUidAndRid(Integer uid, Integer rid);

	List<UserRole> getAllUserRole();

	int deleteUserRole(UserRole userRole);

	int insertUserRole(UserRole userRole);

	int updateUserRole(UserRole userRole);
}
