package com.webcontent.UserPanelUsingSpringJDBC.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.webcontent.UserPanelUsingSpringJDBC.entities.User;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate template;
	
	@Override
	public int insert(User user) {
		String insertQuery="insert into userdb.user(uname, password) values(?,?)";
        int result= template.update(insertQuery,user.getName(),user.getPassword() );      
  
		return result;
	}@Override
	public int update(User oldUser, User newUser) {
		String updateQuery="update userdb.user set uname=? , password=? where uname=?";
        int result= template.update(updateQuery,newUser.getName(),newUser.getPassword(),oldUser.getName() );    
        
		return result;
	}
	@Override
	public int delete(User user) {
		String deleteQuery="delete from userdb.user where uname=?";
        int result= template.update(deleteQuery,user.getName());      
  
		return result;
	}
	@Override
	public User select(String name) {
		String selectQuery="select * from userdb.user where uname=?";
		RowMapper<User>rowMapper=new RowMapperImpl();
		return template.queryForObject(selectQuery,rowMapper,name);
        
	}
	@Override
	public List<User> selectAll() {
		String selectQuery="select * from userdb.user";
		RowMapper<User>rowMapper=new RowMapperImpl();
		return template.query(selectQuery,rowMapper);
		
	}
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
