package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private String gender;
	private Date dateBirth;
	private boolean active;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Address address;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	private NumberPhone numberPhone;
	
	public Person() {
		
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address endereco) {
		this.address = endereco;
	}
	
	public NumberPhone getNumberPhone() {
		return numberPhone;
	}
	
	public void setNumberPhone(NumberPhone numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
