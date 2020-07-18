package Ropa.Ascari.TechStore.Entities;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity @Data 
@Table(name = "CustomerAccounts", schema="TechStore")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name ="CustomerFirstName")
	private String firstname;
	@Column(name ="CustomerLastName")
	private String lastname;
	@Column(name ="CustomerUsername")
	private String username;
	@Column(name ="CustomerPassword")
	private String password;
	@Column(unique=true,name ="CustomerEmail")
	private String email;
	@Id @GeneratedValue
	@Column(name ="CustomerID")
	private int id;
	
	
	public Customer() {
		super();
	}

	public Customer(String firstname, String lastname, String username, String password, String email, int id) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", email=" + email + ", id=" + id + "]";
	}

	
	
}