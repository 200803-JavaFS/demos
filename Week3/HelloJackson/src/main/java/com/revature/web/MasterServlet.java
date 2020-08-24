package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AvengerController;
import com.revature.controllers.LoginController;
import com.revature.models.Avenger;

public class MasterServlet extends HttpServlet {

	private static AvengerController ac = new AvengerController();
	private static LoginController lc = new LoginController();
	
	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		// By default tomcat will send back a successful status code if it finds a
		// servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
		res.setStatus(404);

		final String URI = req.getRequestURI().replace("/HelloJackson/", "");

		// example URI = avenger/1 to get avenger with ID 1 
		
		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));

		
		try {
			switch (portions[0]) {
			case "avenger":
				if (req.getMethod().equals("GET")) {
					if (portions.length == 2) {
						int id = Integer.parseInt(portions[1]);
						ac.getAvenger(res, id);
					}else if (portions.length == 1){
						ac.getAllAvengers(res);
					}
				} else if(req.getMethod().equals("POST")) {
					ac.addAvenger(req, res);
				}
				break;
			case "login":
				lc.login(req, res);
				break;
			case "logout":
				lc.logout(req, res);
				break;
			}
			
				
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("The id you provided is not an integer");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
