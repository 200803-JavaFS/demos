package com.revature;

import java.util.List;

import com.revature.daos.CharacterDAO;
import com.revature.daos.DirectorDAO;
import com.revature.daos.MovieDAO;
import com.revature.models.Character;
import com.revature.models.Director;
import com.revature.models.Movie;

public class Driver {
	
	public static CharacterDAO charDao = new CharacterDAO();
	public static MovieDAO mDao = new MovieDAO();
	public static DirectorDAO dirDao = new DirectorDAO();

	public static void main(String[] args) {
		
		insertValues();
		
		List<Movie> movies = mDao.findAll();
		
		for(Movie m : movies) {
			System.out.println(m);
		}
	

	}
	
	public static void insertValues() {
		Director dir1 = new Director("Christopher", "Nolen", null);
		Director dir2 = new Director("Steven", "Speilburgh", null);
		Director dir3 = new Director("Wes", "Anderson", null);
		dirDao.insert(dir1);
		dirDao.insert(dir2);
		dirDao.insert(dir3);
		
		Movie m1 = new Movie("Jurassic Park", "Don't feed the lizards", dir2);
		Movie m2 = new Movie("Dark Knight Rise", "I mean DC is trying right?", dir1);
		Movie m3 = new Movie("Moon Rise Kingdom", "I have no idea", dir3);
		Movie m4 = new Movie("ET", "Always be nice to strangers", dir2);
		mDao.insert(m1);
		mDao.insert(m2);
		mDao.insert(m3);
		mDao.insert(m4);
		
		Character c1 = new Character("T-Rex", "female", "hunger");
		Character c2 = new Character("Batman", "male", "justice");
		charDao.insert(c1);
		charDao.insert(c2);
	}

}
