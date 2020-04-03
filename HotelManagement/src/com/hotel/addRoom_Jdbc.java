package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class addRoom_Jdbc 
{
	public static boolean addroom(String hot_id,String room_id,String room_no, String room_type, String price_night,String avb)
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
			
			String s=" Insert into room"
					+" value(?,?,?,?,?,?) ";
			
             ptmt = con.prepareStatement(s); 
			
			ptmt.setString(1, hot_id);
			ptmt.setString(2, room_id);
			ptmt.setString(3, room_no);
			ptmt.setString(4,room_type);
			ptmt.setString(6, price_night);
			ptmt.setString(5,avb);
			
			
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
			
			



         


