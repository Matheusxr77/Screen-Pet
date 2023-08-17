package br.edu.ufape.screenpet.business.basic;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VaccinationCalendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;
	private Date frequency;
	
	public VaccinationCalendar() {

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
}
