package br.edu.ufape.screenpet.business.basic;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String password;
	private boolean active;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private NumberPhone numberPhone;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	
	public NumberPhone getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(NumberPhone numberPhone) {
		this.numberPhone = numberPhone;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Usuario(String email, String password, boolean active) {
		this.email = email;
		this.password = password;
		this.active = active;
	}
	
	public Usuario() {
	
	}
}