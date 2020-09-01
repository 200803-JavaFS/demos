package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="directors")
public class Director {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dir_id")
	private int dirId;
	
	@Column(name="dir_first_name")
	private String dirFName;
	
	@Column(name="dir_last_name", nullable=false)
	private String dirLName;
	
	@OneToMany(mappedBy="dir", fetch=FetchType.EAGER)
	private List<Movie> movList;
	
	public Director() {
		super();
	}


	public Director(int dirId, String dirFName, String dirLName, List<Movie> movList) {
		super();
		this.dirId = dirId;
		this.dirFName = dirFName;
		this.dirLName = dirLName;
		this.movList = movList;
	}


	public Director(String dirFName, String dirLName, List<Movie> movList) {
		super();
		this.dirFName = dirFName;
		this.dirLName = dirLName;
		this.movList = movList;
	}


	public int getDirId() {
		return dirId;
	}


	public void setDirId(int dirId) {
		this.dirId = dirId;
	}


	public String getDirFName() {
		return dirFName;
	}


	public void setDirFName(String dirFName) {
		this.dirFName = dirFName;
	}


	public String getDirLName() {
		return dirLName;
	}


	public void setDirLName(String dirLName) {
		this.dirLName = dirLName;
	}


	public List<Movie> getMovList() {
		return movList;
	}


	public void setMovList(List<Movie> movList) {
		this.movList = movList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dirFName == null) ? 0 : dirFName.hashCode());
		result = prime * result + dirId;
		result = prime * result + ((dirLName == null) ? 0 : dirLName.hashCode());
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
		Director other = (Director) obj;
		if (dirFName == null) {
			if (other.dirFName != null)
				return false;
		} else if (!dirFName.equals(other.dirFName))
			return false;
		if (dirId != other.dirId)
			return false;
		if (dirLName == null) {
			if (other.dirLName != null)
				return false;
		} else if (!dirLName.equals(other.dirLName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Director [dirId=" + dirId + ", dirFName=" + dirFName + ", dirLName=" + dirLName + "]";
	}
	
	

}
