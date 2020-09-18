package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Avenger;
import com.revature.repositories.IAvengerDAO;

@RestController
@RequestMapping(value="/avenger")
@CrossOrigin
public class AvengerController {

	@Autowired
	private IAvengerDAO dao;
	
	@GetMapping
	public ResponseEntity<List<Avenger>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(dao.findAll());
	}
	
	@PostMapping
	public ResponseEntity<List<Avenger>> insert(@Valid @RequestBody Avenger a){
		System.out.println(a);
		dao.save(a);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dao.findAll());
	}
	
	
}
