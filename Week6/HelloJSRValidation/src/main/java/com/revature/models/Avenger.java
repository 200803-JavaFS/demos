package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="avengers")
@Component
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString 
public class Avenger {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@PositiveOrZero
	private int supID;
	
	@Size(min=2, max=30, message="Your name must be between 2 and 30 characters")
	private String supName;
	
	@NotEmpty(message="You're a superhero you need a real power.")
	private String supPower;
	
	@NotBlank(message="You have a name, I know it.")
	private String firstName;
	private String lastName;
	@Positive(message="You can't be that bad, really.")
	private int powerLevel;
	

	public Avenger(int supID, String supName, String supPower, String firstName, String lastName, int powerLevel) {
		super();
		this.supID = supID;
		this.supName = supName;
		this.supPower = supPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
	}


	public Avenger(String supName, String supPower, String firstName, String lastName, int powerLevel) {
		super();
		this.supName = supName;
		this.supPower = supPower;
		this.firstName = firstName;
		this.lastName = lastName;
		this.powerLevel = powerLevel;
	}
	
	
	
}
