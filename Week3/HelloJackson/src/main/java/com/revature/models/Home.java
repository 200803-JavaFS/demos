package com.revature.models;

import java.io.Serializable;

public class Home implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String homeBase;
	private String streetAddr;
	private String city;
	private String state;
	private String zip;
	
	public Home() {
		super();
	}

	public Home(String homeBase, String streetAddr, String city, String state, String zip) {
		super();
		this.homeBase = homeBase;
		this.streetAddr = streetAddr;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getHomeBase() {
		return homeBase;
	}

	public void setHomeBase(String homeBase) {
		this.homeBase = homeBase;
	}

	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((homeBase == null) ? 0 : homeBase.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddr == null) ? 0 : streetAddr.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Home other = (Home) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (homeBase == null) {
			if (other.homeBase != null)
				return false;
		} else if (!homeBase.equals(other.homeBase))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddr == null) {
			if (other.streetAddr != null)
				return false;
		} else if (!streetAddr.equals(other.streetAddr))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Home [homeBase=" + homeBase + ", streetAddr=" + streetAddr + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}
	
	
	
	

}
