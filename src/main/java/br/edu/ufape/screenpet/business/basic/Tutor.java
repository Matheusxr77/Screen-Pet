package br.edu.ufape.screenpet.business.basic;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Tutor extends Person {
	public Tutor(String name, String cpf, String gender, Date birthday, boolean active) {
		super(name, cpf, gender, birthday, active);
	}
	
	public Tutor() {

	}
}