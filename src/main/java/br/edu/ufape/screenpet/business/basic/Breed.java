package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Breed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	
	public Breed() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
