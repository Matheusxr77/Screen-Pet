package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class VaccinationCalendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;
	private Date frequency;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<VaccinationHistoric> vaccinationHistoric;
	
	public List<VaccinationHistoric> getVaccinationHistoric() {
		return vaccinationHistoric;
	}

	public void setVaccinationHistoric(List<VaccinationHistoric> vaccinationHistoric) {
		this.vaccinationHistoric = vaccinationHistoric;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getFrequency() {
		return frequency;
	}

	public void setFrequency(Date frequency) {
		this.frequency = frequency;
	}

	public VaccinationCalendar(long id, Date date, Date frequency, List<VaccinationHistoric> vaccinationHistoric) {
		super();
		this.id = id;
		this.date = date;
		this.frequency = frequency;
		this.vaccinationHistoric = vaccinationHistoric;
	}
}
