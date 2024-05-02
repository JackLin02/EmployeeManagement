package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserRoleDao;
import com.ssm.model.UserRole;
import com.ssm.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleDao userRoleDao;

	@Override
	public UserRole getUserRoleByeUidAndRid(Integer uid, Integer rid) {
		return userRoleDao.getUserRoleByeUidAndRid(uid, rid);
	}

	@Override
	public List<UserRole> getAllUserRole() {
		return userRoleDao.getAllUserRole();
	}

	@Override
	public int deleteUserRole(UserRole userRole) {
		return userRoleDao.deleteUserRole(userRole);
	}

	@Override
	public int insertUserRole(UserRole userRole) {
		return userRoleDao.insertUserRole(userRole);
	}

	@Override
	public int updateUserRole(UserRole userRole) {
		return userRoleDao.updateUserRole(userRole);
	}

}
