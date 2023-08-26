package br.edu.ufape.screenpet.business.basic;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private String gender;
	private Date dateBirth;
	private boolean active;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private NumberPhone numberPhone;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person(String name, String cpf, String gender, Date dateBirth, boolean active) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.gender = gender;
		this.dateBirth = dateBirth;
		this.active = active;
	}
}