package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CheckUser_jdbc 
{       
	static String name1="";
	static String password1="";


	public static boolean checkuser(String username,String pass,String fullname, String mob, String add,String email)
	{
	
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		boolean b=false;
		
		try 
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			
			String url="jdbc:mysql://localhost:3306/project?user=root&password=root";
			con =DriverManager.getConnection(url);
			
			String s=" select * from user";
			  stmt=con.createStatement(); 
			res=stmt.executeQuery(s);
			
			while(res.next())
			{
				name1=res.getString("username");
				password1=res.getString("password");
			
				if(name1.equals(username)&&password1.equals(pass))
				{
					b=true;
					break;
				}
			}
         
}
		catch (SQLException e)
        {

            e.printStackTrace();
        }
		return b;
	}
}
