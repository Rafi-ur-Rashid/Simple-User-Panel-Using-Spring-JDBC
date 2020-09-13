package com.webcontent.UserPanelUsingSpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webcontent.UserPanelUsingSpringJDBC.dao.UserDaoImpl;
import com.webcontent.UserPanelUsingSpringJDBC.entities.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/webcontent/UserPanelUsingSpringJDBC/config.xml");
 //       JdbcTemplate template= context.getBean("jdbcTemplate",JdbcTemplate.class);
          
//        String insertQuery="insert into userdb.user(uname, password) values(?,?)";
//        int result= template.update(insertQuery,"Yash","bree" );
        User user1=context.getBean("user",User.class);
        User user2=context.getBean("user2",User.class);
        UserDaoImpl userDaoImpl=context.getBean("userDaoImpl",UserDaoImpl.class);
        //System.out.println(userDaoImpl.insert(user1));
//        System.out.println(userDaoImpl.update(user1, user2));
//        System.out.println(userDaoImpl.delete(user2));
//        User user=userDaoImpl.select("Yash");
//        System.out.println(user.getName()+" "+user.getPassword());
        List<User> users=userDaoImpl.selectAll();
        for(User u:users)
        {
        	System.out.println(u.getName()+" "+u.getPassword());
        }
    }
}
