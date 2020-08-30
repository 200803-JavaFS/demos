package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.models.AvengerDTO;
import com.revature.services.AvengerService;

public class AvengerController {
	
	private static AvengerService as = new AvengerService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getAvenger(HttpServletResponse res, int id) throws IOException {
		Avenger a = as.findById(id);
		if(a == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(a);
			res.getWriter().println(json);
		}
		
	}
	
	public void getAllAvengers(HttpServletResponse res) throws IOException {
		List<Avenger> all = as.findAll();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
	}

	public void addAvenger(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println(body);
		
		AvengerDTO a = om.readValue(body, AvengerDTO.class);
		
		System.out.println(a);
		
		if (as.addAvenger(a)) {
			res.setStatus(201);
			res.getWriter().println("Avenger was created");
		} else {
			res.setStatus(403);
		}
		
	}

}
