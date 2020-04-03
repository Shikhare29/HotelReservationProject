package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class showRoom_Jdbc 
{
     public static ResultSet showroom(String city1, String Room)
     {
    	 Connection con =null;
    	 Statement stmt=null;
    	 ResultSet res=null;
    	 
    	 try
    	 {
    		 Driver ref=new Driver();
    			DriverManager.registerDriver(ref);
    			String url="jdbc:mysql://localhost:3306/project?user=root&password=root";
    			con =DriverManager.getConnection(url);
    			String s=" select * from hotel ";
    			stmt = con.createStatement();
    			 res=stmt.executeQuery(s);
    	 }
    	 catch (SQLException e)
    	    {

    	        e.printStackTrace();
    	    }
    	 return res;
     }
}
