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

	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

=======
	
	public VaccinationHistoric() {

	}
	
	public String getComments() {
		return comments;
	}
	
	public void setcomments(String comments) {
		this.comments = comments;
	}
>>>>>>> e68e30fb3f39a77f33b1b93a004c2be74a7acc10
}
