package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regHotelServlet extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
	  PrintWriter out=resp.getWriter();
	  
	  String hot_id = req.getParameter("hid");
		String city = req.getParameter("city");
		String ht_name=req.getParameter("name");
		String address = req.getParameter("address");
		String des= req.getParameter("address");
		String ppn = req.getParameter("rate");
		String phone1 = req.getParameter("ph1");
		String phone2 = req.getParameter("ph2");
        String rating = req.getParameter("rating");
		String email = req.getParameter("email");
		
		boolean status=addHotel_Jdbc.addhotel(hot_id,city,ht_name,address,des,ppn,phone1,phone2,rating,email);
		
		 if(status)
		  {
		    String url="adminOptions.html";
		    RequestDispatcher rd=req.getRequestDispatcher(url);
		    rd.forward(req, resp);
		  }
		  else
		  {
			  out.println("hotel not added.....!");
		  }
		  
		
}
}
