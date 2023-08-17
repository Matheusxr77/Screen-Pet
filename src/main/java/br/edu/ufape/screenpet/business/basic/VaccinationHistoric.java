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
	
<<<<<<< HEAD
	public VaccinationHistoric (int id, String comments) {
=======
	public VaccinationHistoric() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 541c357cf4cace52b1ff186d8ae82deda3c97944
		
=======
>>>>>>> 50d23a182b5c8d83f3fd31993b7ce3b42ddbfcdb

	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setcomments(String comments) {
		this.comments = comments;
	}
}
