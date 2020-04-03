package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class addHotel_Jdbc 
{
	public static boolean addhotel(String hot_id,String city,String ht_name, String address, String des,String ppn, String phone1, String phone2,String rating,String email)
	{
	
		Connection con=null;
		PreparedStatement ptmt=null;
		boolean b=false;
		
		try 
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			
			String url="jdbc:mysql://localhost:3306/project?user=root&password=root";
			con =DriverManager.getConnection(url);
			
			String s=" Insert into hotel"
					+" value(?,?,?,?,?,?,?,?,?,?) ";
			
             ptmt = con.prepareStatement(s); 
			
			ptmt.setString(1, hot_id);
			ptmt.setString(2, city);
			ptmt.setString(3, ht_name);
			ptmt.setString(4,address );
			ptmt.setString(6, des);
			ptmt.setString(5,ppn);
			ptmt.setString(7, phone1);
			ptmt.setString(8, phone2);
			ptmt.setString(9, rating);
			ptmt.setString(10, email);
			
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
			
			



         

