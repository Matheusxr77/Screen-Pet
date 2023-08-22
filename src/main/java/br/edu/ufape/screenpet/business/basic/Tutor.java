package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

	public Tutor(long id, String name, String cpf, String gender, Date dateBirth, boolean active, List<Address> address, List<NumberPhone> numberPhone, User user, List<Pet> pets) {
		super(id, name, cpf, gender, dateBirth, active, address, numberPhone, user);
		this.pets = pets;
	}
}
