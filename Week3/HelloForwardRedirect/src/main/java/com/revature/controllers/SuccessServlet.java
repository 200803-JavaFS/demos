package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {

	public SuccessServlet() {
		super();
	}
	
	//This is bad practice, usually we would use doGet and doPost etc. 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<h2>Welcome "+req.getParameter("userId")+"!</h2>");
		out.print("<a href='logout'>Click here to log out</a>");
	}
	
	

}
