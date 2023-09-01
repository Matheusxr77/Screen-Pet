package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class Attendant extends Person {
	public Attendant(String name, String cpf, String gender, Date birthday, boolean active) {
		super(name, cpf, gender, birthday, active);
	}
	
	public Attendant() {
		
	}
}