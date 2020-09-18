package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode 
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int pokeId;
	private int pokedexId;
	private String name;
	private int baseXP;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
	private Trainer trainer;

	public Pokemon(int pokeId, int pokedexId, String name, int baseXP, Trainer trainer) {
		super();
		this.pokeId = pokeId;
		this.pokedexId = pokedexId;
		this.name = name;
		this.baseXP = baseXP;
		this.trainer = trainer;
	}

	public Pokemon(int pokedexId, String name, int baseXP, Trainer trainer) {
		super();
		this.pokedexId = pokedexId;
		this.name = name;
		this.baseXP = baseXP;
		this.trainer = trainer;
	}


	@Override
	public String toString() {
		return "Pokemon [pokeId=" + pokeId + ", pokedexId=" + pokedexId + ", name=" + name + ", baseXP=" + baseXP
				+ ", trainer=" + trainer.gettId() + "]";
	}

	
	
}
