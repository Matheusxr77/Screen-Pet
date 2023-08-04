package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pet {
	@Id
	private String id;

}