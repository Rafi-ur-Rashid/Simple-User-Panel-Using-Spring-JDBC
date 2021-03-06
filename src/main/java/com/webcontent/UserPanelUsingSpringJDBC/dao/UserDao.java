package com.webcontent.UserPanelUsingSpringJDBC.dao;

import java.util.List;

import com.webcontent.UserPanelUsingSpringJDBC.entities.User;

public interface UserDao {
	public int insert(User user);
	public int update(User oldUser, User newUser);
	public int delete(User user);
	public User select(String name);
	public List<User> selectAll();
	
}
