package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.bean.User;


public class NewUserDAO 
{
	public boolean loginUser(Connection con,User user)
	{
		boolean ans=false;
		String query1="select * from user where username=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(query1);
			pstat.setString(1,user.getUsername());
			ResultSet rs=pstat.executeQuery();
			rs.next();
			if((user.getUsername()).equals(rs.getString(2)) && (user.getPassword()).equals(rs.getString(3)) )
			{
				ans=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}
	public User getUserByUsername(Connection con,String username)
	{
		String query2="select * from user where username=?";
		User user=null;
		try
		{
			PreparedStatement pstat=con.prepareStatement(query2);
			pstat.setString(1, username);
			ResultSet rs=pstat.executeQuery();
			if(rs.next())
			{
				user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	public boolean updateProfile(Connection con,User user)
	{
		String query3="update user set password=? where rollno=?";
		try
		{
			PreparedStatement pstat=con.prepareStatement(query3);
			pstat.setString(1, user.getPassword());
			pstat.setInt(2, user.getRollno());
			int rows=pstat.executeUpdate();
			return rows>0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}		
	}


}
