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
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private int frequency;
	private String comments;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<VaccinationHistoric> vaccinationHistoric;
	
	
	public List<VaccinationHistoric> getVaccinationHistoric() {
		return vaccinationHistoric;
	}

	public void setVaccinationHistoric(List<VaccinationHistoric> vaccinationHistoric) {
		this.vaccinationHistoric = vaccinationHistoric;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType () {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}

	public Vaccine(int id, String name, String type, int frequency, String comments, List<VaccinationHistoric> vaccinationHistoric) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.frequency = frequency;
		this.comments = comments;
		this.vaccinationHistoric = vaccinationHistoric;
	}
}