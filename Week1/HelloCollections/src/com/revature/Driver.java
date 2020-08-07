package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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
				//p.compareTo(myPokemon.get(0));
			}
			
			System.out.println("=================================================");
			
//			Collections.sort(myPokemon);
//			
//			for(Pokemon p: myPokemon) {
//				System.out.println(p);
//			}
			
			Collections.sort(myPokemon, new ComparePokeName());
			//Collections.reverse(myPokemon);
			
			for(Pokemon p: myPokemon) {
				System.out.println(p);
			}
			
			System.out.println("=================================================");
			
			//This sort method is using a lambda expression with the Functional Interface of Comparator. 
			Collections.sort(myPokemon, (Pokemon p1, Pokemon p2) -> {return p1.number-p2.number;});
			
			for(Pokemon p: myPokemon) {
				System.out.println(p);
			}
			
			System.out.println("=================================================");

			//NOTE: Even though this is the Collections demo, Maps are not part of the collections api. 
			
			
			Map<String, Pokemon> trainers = new TreeMap<>(); 
			
			trainers.put("Alex", myPokemon.get(0));
			trainers.put("Brittany", new Pokemon(132, "Ditto", "Normal"));
			trainers.put("Nancy", new  Pokemon(7, "Squirtle", "Water"));
			trainers.put("Elizabeth", new Pokemon(82, "Magneton", "Electric"));
			trainers.put("Sheri", new Pokemon(151, "Mew", "Psychic"));
			trainers.put("Nicole", new Pokemon(133, "Eevee", "Normal"));
			//trainers.put("Alex", new Pokemon(3, "Venusaur", "Grass/Poison"));
			
			
			Set<Entry<String, Pokemon>> set = trainers.entrySet();
			
//			for(Entry<String, Pokemon> e: set) {
//				System.out.println(e);
//			}
//			
//			System.out.println("=================================================");
			Iterator it = set.iterator();
			
			
			//hasNext returns true if there is a further value to iterate over. 
			while(it.hasNext()) {
				Map.Entry<String, Pokemon> pair = (Entry<String, Pokemon>) it.next();
				System.out.println(pair.getKey() + " => " +pair.getValue());
			}
	}

}
