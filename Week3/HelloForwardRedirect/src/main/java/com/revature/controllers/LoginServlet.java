package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		User u = new User(); 
		
		u.setUsername(req.getParameter("userId"));
		u.setPassword(req.getParameter("password"));
		
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if(u.getUsername().equals("tom") && u.getPassword().equals("jerry")) {
			rd = req.getRequestDispatcher("success");
			rd.forward(req, res);
		} else {
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
		}
		
	}

}
