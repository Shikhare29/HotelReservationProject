package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
import java.sql.Statement;

public class showData extends HttpServlet
{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
 {
	PrintWriter out= resp.getWriter();
	
	String city1=req.getParameter("city");
	String roomtype=req.getParameter("rtype");

	
	Connection con =null;
	Statement stmt = null;
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
		 out.println("<table border=2 width=50% height=50%>");
		 out.println("<tr><th>hotel_id</th><th>city</th><th>hotel_name</th><th>address</th><th>discription</th><th>price_per_night</th><th>phone1</th><th>phone2</th><th>rating</th><th>email</th></tr>");
		
	while(res.next())
	{
	    String hot_id = res.getString("hotel_id");
		String city = res.getString("city");
		String ht_name=res.getString("hotel_name");
		String address = res.getString("address");
		String des= res.getString("discription");
		String ppn = res.getString("price_per_night");
		String phone1 = res.getString("phone1");
		String phone2 = res.getString("phone2");
        String rating = res.getString("rating");
		String email = res.getString("email");
		
		out.println("<tr><td>"+hot_id+"</td><td>"+city+"</td><td>"+ht_name+"</td><td>"+address+"</td><td>"+des+"</td><td>"+ppn+"</td><td>"+phone1+"</td><td>"+phone2+"</td><td>"+rating+"</td><td>"+email+"</td></tr>");
	}
	out.println("</table>");
	}
	catch (SQLException e)
    {

        e.printStackTrace();
    }
	
		
	}
}
