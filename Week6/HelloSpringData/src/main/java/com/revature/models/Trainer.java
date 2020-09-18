package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
public class Trainer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int tId;
	private String name;
	
	@OneToMany(mappedBy="trainer", fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Pokemon> party;

	public Trainer(int tId, String name, List<Pokemon> party) {
		super();
		this.tId = tId;
		this.name = name;
		this.party = party;
	}

	public Trainer(String name, List<Pokemon> party) {
		super();
		this.name = name;
		this.party = party;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getParty() {
		return party;
	}

	public void setParty(List<Pokemon> party) {
		this.party = party;
	}

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
}
