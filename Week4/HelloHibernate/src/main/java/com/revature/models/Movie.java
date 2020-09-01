package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movId;
	
	@Column(name="movie_name", unique=true)
	private String movName;
	
	@Column(name="movie_description")
	private String movDescription;
	
	//FetchType defines when hibernate will go to the database to fetch an associated object. 
		/*Lazy - Hibernate will give a proxy object instead of going to the database until 
		 * your code actually calls for the object. this only works while the object is persistent. 
		 * Once it becomes detached there is no longer as Session to replace the proxy*/
		/*Eager - returns the dependent object immediately with no proxy. This is generally safer.*/
		//Cascade defines how the queries will maintain referential integrity. 
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="dir_id")
	private Director dir;
	
	public Movie() {
		super();
	}

	public Movie(int movId, String movName, String movDescription, Director dir) {
		super();
		this.movId = movId;
		this.movName = movName;
		this.movDescription = movDescription;
		this.dir = dir;
	}

	public Movie(String movName, String movDescription, Director dir) {
		super();
		this.movName = movName;
		this.movDescription = movDescription;
		this.dir = dir;
	}

	public int getMovId() {
		return movId;
	}

	public void setMovId(int movId) {
		this.movId = movId;
	}

	public String getMovName() {
		return movName;
	}

	public void setMovName(String movName) {
		this.movName = movName;
	}

	public String getMovDescription() {
		return movDescription;
	}

	public void setMovDescription(String movDescription) {
		this.movDescription = movDescription;
	}

	public Director getDir() {
		return dir;
	}

	public void setDir(Director dir) {
		this.dir = dir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + ((movDescription == null) ? 0 : movDescription.hashCode());
		result = prime * result + movId;
		result = prime * result + ((movName == null) ? 0 : movName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (dir == null) {
			if (other.dir != null)
				return false;
		} else if (!dir.equals(other.dir))
			return false;
		if (movDescription == null) {
			if (other.movDescription != null)
				return false;
		} else if (!movDescription.equals(other.movDescription))
			return false;
		if (movId != other.movId)
			return false;
		if (movName == null) {
			if (other.movName != null)
				return false;
		} else if (!movName.equals(other.movName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movId=" + movId + ", movName=" + movName + ", movDescription=" + movDescription + ", dir=" + dir
				+ "]";
	} 
	
	

}
