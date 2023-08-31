package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class Attendant extends Person {
	public Attendant(String name, String cpf, String gender, Date dateBirth, boolean active) {
		super(name, cpf, gender, dateBirth, active);
	}
	
	public Attendant() {
		// TODO Auto-generated constructor stub
	}
}