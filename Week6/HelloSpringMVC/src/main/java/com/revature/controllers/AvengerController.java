package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerDAO;

@Controller
//Adding the URI mapping for what requests this controller will handle
@RequestMapping(value="/avenger")
@ResponseBody //This will at compile time add @ResponseBody to all methods in the class
public class AvengerController {

	private AvengerDAO dao;

	@Autowired 
	public AvengerController(AvengerDAO dao) {
		super();
		this.dao = dao;
	}

	//indicates that a get method to the base URI of the controller (/avenger) will call this method.
	@RequestMapping(method=RequestMethod.GET)
	//@ResponseBody //This will make sure the response is sent back with JSON
	public List<Avenger> assemble() {
		return Arrays.asList(dao.getAll());
	}
	
	@GetMapping("/{id}") //Get mapping will direct GET requests to the given mapping. It avoids having to use the method paramater
	public ResponseEntity<Avenger> findById(@PathVariable("id") int id) { //@PathVariable allows you to get the Path Parameter out of the URI
		Avenger a = dao.getById(id);
		if(a==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //sends back an empty body in the response. 
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
	@PutMapping
	public ResponseEntity<Avenger> update(@RequestBody Avenger a) {// Takes the JSON from the request and puts it in the indicated object
		a = dao.update(a);
		if(a==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //sends back an empty body in the response. 
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
}
