package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.models.Pokemon;

public class Driver {

	public static void main(String[] args) {

			List<Pokemon> myPokemon = new ArrayList<>();
			
			myPokemon.add(new Pokemon(1, "Bulbasaur", "Grass"));
			myPokemon.add(new Pokemon(4, "Charmander", "Fire"));
			myPokemon.add(new Pokemon(7, "Squirtle", "Water"));
			myPokemon.add(new Pokemon(25, "Pikachu", "Electric"));
			myPokemon.add(new Pokemon(151, "Mew", "Psychic"));
			myPokemon.add(new Pokemon(25, "1Pikachu", "Electric"));
			myPokemon.add(new Pokemon(25, "pikachu", "Electric"));
			myPokemon.add(new Pokemon(95, "Onix", "Rock"));
			myPokemon.add(new Pokemon(95, "onix", "Rock"));
			myPokemon.add(new Pokemon(4, "Charmander", "Fire"));
			
			//This is an enhanced for loop used to iterate over the entirety of the data structure. 
			for(Pokemon p: myPokemon) {
				System.out.println(p);
			}
			
			System.out.println(myPokemon.size());
			System.out.println(myPokemon.get(5));
			
			System.out.println("=================================================");
			
			HashSet<Pokemon> mySet = new HashSet<>();
			
			mySet.add(new Pokemon(1, "Bulbasaur", "Grass"));
			mySet.add(new Pokemon(4, "Charmander", "Fire"));
			mySet.add(new Pokemon(7, "Squirtle", "Water"));
			mySet.add(new Pokemon(25, "Pikachu", "Electric"));
			mySet.add(new Pokemon(151, "Mew", "Psychic"));
			mySet.add(new Pokemon(25, "1Pikachu", "Electric"));
			mySet.add(new Pokemon(25, "pikachu", "Electric"));
			mySet.add(new Pokemon(95, "Onix", "Rock"));
			mySet.add(new Pokemon(95, "onix", "Rock"));
			mySet.add(new Pokemon(4, "Charmander", "Fire"));
			
			for(Pokemon p: mySet) {
				System.out.println(p);
			}
			
			
	}

}
