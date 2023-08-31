package br.edu.ufape.screenpet.business.basic;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Diagnosis {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String symptoms;
    private String patology;
    private String prescription;
    private String comments;
    
    @ManyToOne
	@Cascade(CascadeType.ALL)
    private Pet pet;
    
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Diagnosis(String symptoms, String patology, String prescription, String comments) {
		this.symptoms = symptoms;
		this.patology = patology;
		this.prescription = prescription;
		this.comments = comments;
	}
	
	public Diagnosis() {
		// TODO Auto-generated constructor stub
	}
}