package com.revature.models;

public class AvengerDTO {
	
	public int supId;
	public String supName;
	public String supPower;
	public String firstName;
	public String lastName;
	public int powerLevel;
	public String homeString;
	
	
	
	public AvengerDTO() {
		super();
	}

	public AvengerDTO(String supName, String supPower, String firstName, String lastName, int powerLevel,
			String homeString) {
		super();
		this.supName = supName;
		this.supPower = supPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
		this.homeString = homeString;
	}



	public AvengerDTO(int supId, String supName, String supPower, String firstName, String lastName, int powerLevel,
			String homeString) {
		super();
		this.supId = supId;
		this.supName = supName;
		this.supPower = supPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
		this.homeString = homeString;
	}

	@Override
	public String toString() {
		return "AvengerDTO [supId=" + supId + ", supName=" + supName + ", supPower=" + supPower + ", firstName="
				+ firstName + ", lastName=" + lastName + ", powerLevel=" + powerLevel + ", homeString=" + homeString
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homeString == null) ? 0 : homeString.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + powerLevel;
		result = prime * result + supId;
		result = prime * result + ((supName == null) ? 0 : supName.hashCode());
		result = prime * result + ((supPower == null) ? 0 : supPower.hashCode());
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
		AvengerDTO other = (AvengerDTO) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homeString == null) {
			if (other.homeString != null)
				return false;
		} else if (!homeString.equals(other.homeString))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (powerLevel != other.powerLevel)
			return false;
		if (supId != other.supId)
			return false;
		if (supName == null) {
			if (other.supName != null)
				return false;
		} else if (!supName.equals(other.supName))
			return false;
		if (supPower == null) {
			if (other.supPower != null)
				return false;
		} else if (!supPower.equals(other.supPower))
			return false;
		return true;
	}
	
	
}
