package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.model.User;

@Repository("userDao")
public interface UserDao {

	User getUser(Integer id);

	User getUserByEmail(String email);

	List<User> getAllUser();

	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(User user);
}