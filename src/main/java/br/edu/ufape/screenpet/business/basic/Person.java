package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Address> address;

	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<NumberPhone> numberPhone;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Address> getAddress() {
		return address;
	}
	
	public void setAddress(List<Address> endereco) {
		this.address = endereco;
	}
	
	public List<NumberPhone> getNumberPhone() {
		return numberPhone;
	}
	
	public void setNumberPhone(List<NumberPhone> numberPhone) {
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

	public Person(String name, String cpf, String gender, Date dateBirth, boolean active, List<Address> address, List<NumberPhone> numberPhone, Usuario usuario) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.gender = gender;
		this.dateBirth = dateBirth;
		this.active = active;
		this.address = address;
		this.numberPhone = numberPhone;
		this.usuario = usuario;
	}
}