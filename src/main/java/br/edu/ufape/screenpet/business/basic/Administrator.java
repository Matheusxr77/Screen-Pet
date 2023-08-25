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
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Administrator(String name, String cpf, String gender, Date dateBirth, boolean active, List<Address> address, List<NumberPhone> numberPhone, Usuario usuario, List<Usuario> usuarios) {
		super(name, cpf, gender, dateBirth, active, address, numberPhone, usuario);
		this.usuarios = usuarios;
	}
}