package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Diagnosis {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String symptoms;
    private String patology;
    private String prescription;
    private String comments;
    
    public Diagnosis() {
    	
    }

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getPatology() {
		return patology;
	}

	public void setPatology(String patology) {
		this.patology = patology;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
