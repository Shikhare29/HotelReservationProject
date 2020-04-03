package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class roomServlet extends HttpServlet
{
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	   {
	 	  PrintWriter out=resp.getWriter();
	 	  
	 	  String hot_id = req.getParameter("hid");
	 		String room_id = req.getParameter("rid");
	 		String room_no=req.getParameter("rino");
	 		String room_type = req.getParameter("rtype");
	 		String price_night= req.getParameter("rate");
	 		String avb = req.getParameter("avail");
	 		
	 		
	boolean status=addRoom_Jdbc.addroom(hot_id,room_id,room_no,room_type,price_night,avb);
	 		
	 		 if(status)
	 		  {
	 		    String url="adminOptions.html";
	 		    RequestDispatcher rd=req.getRequestDispatcher(url);
	 		    rd.forward(req, resp);
	 		  }
	 		  else
	 		  {
	 			  out.println("room not added.....!");
	 		  }
	 		  
	 		
	 }
	 }


