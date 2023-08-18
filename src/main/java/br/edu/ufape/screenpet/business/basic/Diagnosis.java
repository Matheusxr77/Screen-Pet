package br.edu.ufape.screenpet.business.basic;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Diagnosis {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String symptoms;
    private String patology;
    private String prescription;
    private String comments;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Treatment> treatments;
    
    public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
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

	public Diagnosis(long id, String symptoms, String patology, String prescription, String comments, List<Treatment> treatments) {
		super();
		this.id = id;
		this.symptoms = symptoms;
		this.patology = patology;
		this.prescription = prescription;
		this.comments = comments;
		this.treatments = treatments;
	}
}