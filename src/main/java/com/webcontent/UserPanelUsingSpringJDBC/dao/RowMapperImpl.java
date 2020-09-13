package com.webcontent.UserPanelUsingSpringJDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.webcontent.UserPanelUsingSpringJDBC.entities.User;

public class RowMapperImpl implements RowMapper<User>{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
		return user;
	}
}
