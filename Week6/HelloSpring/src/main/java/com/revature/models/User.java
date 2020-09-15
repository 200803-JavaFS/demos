package com.revature.models;

public class User {
	
	private int id;
	private String name;
	private Account acc;
	
	public User() {
		super();
	}
	
	
	public User(Account acc) {
		super();
		this.acc = acc;
	}



	public User(int id, String name, Account acc) {
		super();
		this.id = id;
		this.name = name;
		this.acc = acc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc == null) ? 0 : acc.hashCode());
		result = prime * result + id;
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
		User other = (User) obj;
		if (acc == null) {
			if (other.acc != null)
				return false;
		} else if (!acc.equals(other.acc))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", acc=" + acc + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	} 
	
	
	
	

}
