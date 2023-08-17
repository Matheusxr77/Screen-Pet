package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VaccinationHistoric {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String comments;
	
	public VaccinationHistoric (int id, String comments) {
		
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setcomments(String comments) {
		this.comments = comments;
	}
}
