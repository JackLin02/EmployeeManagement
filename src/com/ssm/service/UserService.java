package com.ssm.service;

import java.util.List;

import com.ssm.model.User;

public interface UserService {

	User getUser(Integer id);

	User getUserByEmail(String email);

	List<User> getAllUser();

	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(User user);
}
