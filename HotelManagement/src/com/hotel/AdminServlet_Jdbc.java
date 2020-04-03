package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class AdminServlet_Jdbc 
{
	public static boolean adduser(String username,String pass,String fullname, String mob, String add,String email)
	{
	
		Connection con=null;
		PreparedStatement ptmt=null;
		boolean b=false;
		String id = username.substring(0, 3) + mob.substring(7);
		
		try 
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			
			String url="jdbc:mysql://localhost:3306/project?user=root&password=root";
			con =DriverManager.getConnection(url);
			
			String s=" Insert into user"
					+" value(?,?,?,?,?,?,?,?) ";
         
			 ptmt = con.prepareStatement(s); 
			
			ptmt.setString(1, username);
			ptmt.setString(2, pass);
			
			ptmt.setString(3, id);
			ptmt.setString(4,fullname );
			ptmt.setString(6, mob);
			ptmt.setString(5,"customer");
			ptmt.setString(7, add);
			ptmt.setString(8, email);
			
			int res=ptmt.executeUpdate();
			
            if(res>0)
            {
          	  b=true;
            }
            
          }
         catch (SQLException e)
          {

              e.printStackTrace();
          }

       return b;
}
}
			
			




