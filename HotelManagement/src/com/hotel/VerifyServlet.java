package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
	  PrintWriter out=resp.getWriter();
	  
	    String username = req.getParameter("username");
	    String pass = req.getParameter("pass");
	    String fullname=req.getParameter("fullname");
		String mob = req.getParameter("mob");
		String add = req.getParameter("add");
		String email = req.getParameter("email");
	  boolean status=CheckUser_jdbc.checkuser(username,pass,fullname,mob,add,email);
	  
	  if(username!=null)
	  {
		  if(pass!=null)
		  {
			  if(username.equals("admin")&& pass.equals("admin"))
			  {
				  String url="adminOptions.html";
				  RequestDispatcher rd=req.getRequestDispatcher(url);
				  rd.forward(req, resp);
			  }
			  else if(status)
			  {
				  String url="booking.html";
				   RequestDispatcher rd=req.getRequestDispatcher(url);
				   rd.forward(req, resp);
			  }
			  else
			  {
				  String url="index.html";
				   RequestDispatcher rd=req.getRequestDispatcher(url);
				   rd.forward(req, resp);
			  }
		  }
		  else
		  {
			  out.println("Sucessfully Login.....!!!");
		  }
	  }
	  else
	  {
		  out.println("Login UnSucessfully.....!!!");
	  }
		
}
}
