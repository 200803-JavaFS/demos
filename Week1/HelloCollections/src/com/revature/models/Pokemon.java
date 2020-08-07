package com.revature.models;

public class Pokemon {//implements Comparable<Pokemon>{
	
	public int number;
	public String name;
	public String type;
	
	
	
	public Pokemon() {
		super();
	}



	public Pokemon(int number, String name, String type) {
		super();
		this.number = number;
		this.name = name;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Pokemon [number=" + number + ", name=" + name + ", type=" + type + "]";
	}



	/*
	 * @Override public int compareTo(Pokemon p) { int i =
	 * this.name.toLowerCase().compareTo(p.name.toLowerCase());
	 * System.out.println("The comparison is returning "+i); return i; }
	 */
	
	

}
