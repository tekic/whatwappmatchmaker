package com.whatwapp.matchmaking.dto;

import java.util.Date;

import com.whatwapp.matchmaking.model.User;

public class UserDTO {

	public String firstName;
	public String lastName;
	public Date birthDate;

	public UserDTO() {
	}

	public UserDTO(User user) {
		super();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.birthDate = user.getBirthDate();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}

}
