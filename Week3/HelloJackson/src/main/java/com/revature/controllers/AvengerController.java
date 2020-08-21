package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.services.AvengerService;

public class AvengerController {
	
	private static AvengerService as = new AvengerService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getAvenger(HttpServletResponse res, int id) throws IOException {
		Avenger a = as.findById(id);
		if(a == null) {
			res.setStatus(204);
		} else {
			String json = om.writeValueAsString(a);
			res.getWriter().println(json);
		}
		
	}

}
