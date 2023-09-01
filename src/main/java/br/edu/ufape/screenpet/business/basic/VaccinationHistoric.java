package br.edu.ufape.screenpet.business.basic;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VaccinationHistoric {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String comments;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private VaccinationCalendar vaccinationCalendar;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Vaccine vaccine;

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
	
	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}

	public void setVaccinationCalendar(VaccinationCalendar vaccinationCalendar) {
		this.vaccinationCalendar = vaccinationCalendar;
	}
	
	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public VaccinationHistoric(String comments) {
		this.comments = comments;
	}
	
	public VaccinationHistoric() {

	}
}