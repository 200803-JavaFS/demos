package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repositories.IPokemonDAO;
import com.revature.repositories.ITrainerDAO;

@RestController
@RequestMapping(value="/pokemon")
@CrossOrigin
public class PokemonController {

	private IPokemonDAO pDao;
	private ITrainerDAO tDao;
	
	@Autowired
	public PokemonController(IPokemonDAO pDao, ITrainerDAO tDao) {
		super();
		this.pDao = pDao;
		this.tDao = tDao;
	}
	
	@GetMapping
	public ResponseEntity<List<Trainer>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(tDao.findAll());
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable("id") int id){
		Optional<Trainer> o = tDao.findById(id);
		if(o.isPresent()) {
			Trainer t = o.get();
			return ResponseEntity.status(HttpStatus.OK).body(t);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping(value="/trainer/{name}")
	public ResponseEntity<Trainer> getTrainerByName(@PathVariable("name") String name){
		Trainer t = tDao.findByName(name);
		if(t==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(t);
		}	
	}
	
	@PostMapping
	public ResponseEntity<List<Trainer>> newTrainer(@RequestBody Trainer t){
		tDao.save(t);
		return ResponseEntity.status(HttpStatus.OK).body(tDao.findAll());
	}
	
	
	@PutMapping
	public  ResponseEntity<List<Trainer>> newPokemon(@RequestBody Pokemon p){
		pDao.save(p);
		return ResponseEntity.status(HttpStatus.OK).body(tDao.findAll());
	}
	
	
	
}
