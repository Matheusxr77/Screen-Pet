package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor extends Person {
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Pet> pets;
	
	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Tutor(String name, String cpf, String gender, Date dateBirth, boolean active, List<Address> address, List<NumberPhone> numberPhone, Usuario usuario, List<Pet> pets) {
		super(name, cpf, gender, dateBirth, active, address, numberPhone, usuario);
		this.pets = pets;
	}
}