package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		

			PrintWriter out=resp.getWriter();
			
			String username = req.getParameter("uname");
			String pass = req.getParameter("password");
			String repass = req.getParameter("re-enter");
			String fullname=req.getParameter("fname");
			String mob = req.getParameter("phon");
			String add = req.getParameter("address");
			String email = req.getParameter("email");
			
			
		  boolean status=LoginJdbc.adduser(username,pass,fullname,mob,add,email);
		  
		  if(status)
		  {
		    String url="index.html";
		    RequestDispatcher rd=req.getRequestDispatcher(url);
		    rd.forward(req, resp);
		  }
		  else
		  {
			  out.println("not register.....");
		  }
				  
		}
		}


