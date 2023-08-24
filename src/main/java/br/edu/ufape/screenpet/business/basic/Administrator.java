package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Administrator extends Person {
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Administrator(long id, String name, String cpf, String gender, Date dateBirth, boolean active, List<Address> address, List<NumberPhone> numberPhone, User user, List<User> users) {
		super(id, name, cpf, gender, dateBirth, active, address, numberPhone, user);
		this.users = users;
	}
}