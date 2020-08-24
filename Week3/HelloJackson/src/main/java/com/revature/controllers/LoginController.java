package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {
	
	private static LoginService ls = new LoginService();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//This shows loging in with query params for example purposes only. Do not ever actually do this!
		
		if(req.getParameterMap().containsKey("username") && req.getParameterMap().containsKey("password")) {
			LoginDTO l = new LoginDTO();
			l.username = req.getParameter("username");
			l.password = req.getParameter("password");
			
			if(ls.login(l)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");
			} else {
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login failed");
			}
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);
		
		if(ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(l.username+" has logged out successfully");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}
	}

}