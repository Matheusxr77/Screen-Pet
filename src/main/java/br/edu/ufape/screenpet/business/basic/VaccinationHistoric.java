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
	
	public VaccinationHistoric() {
<<<<<<< HEAD
		
=======

	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
>>>>>>> 2c98b0a8d203c7cec70b651538985f2694b98efa
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
