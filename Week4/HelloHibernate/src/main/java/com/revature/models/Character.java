package com.revature.models;


public class Character {
	
	private int charId;
	private String name;
	private String gender;
	private String motive;
	
	
	public Character() {
		super();
	}


	public Character(int charId, String name, String gender, String motive) {
		super();
		this.charId = charId;
		this.name = name;
		this.gender = gender;
		this.motive = motive;
	}


	public Character(String name, String gender, String motive) {
		super();
		this.name = name;
		this.gender = gender;
		this.motive = motive;
	}


	@Override
	public String toString() {
		return "Character [charId=" + charId + ", name=" + name + ", gender=" + gender + ", motive=" + motive + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charId;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((motive == null) ? 0 : motive.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Character other = (Character) obj;
		if (charId != other.charId)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (motive == null) {
			if (other.motive != null)
				return false;
		} else if (!motive.equals(other.motive))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public int getCharId() {
		return charId;
	}


	public void setCharId(int charId) {
		this.charId = charId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMotive() {
		return motive;
	}


	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	
	

}
