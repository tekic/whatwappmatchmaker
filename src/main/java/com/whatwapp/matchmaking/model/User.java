package com.whatwapp.matchmaking.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document(collection = "users")
public class User {

	@Id
	private String id;

	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date created;

	public User() {
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 */
	public User(String firstName, String lastName, Date birthDate, Date created) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.created = created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s', birthDate='%s', created='%s']", id, firstName, lastName,
				birthDate, created);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
