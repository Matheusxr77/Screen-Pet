package br.edu.ufape.screenpet.business.basic;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class VaccinationHistoric {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String comments;
	
	@OneToMany
	private VaccinationCalendar vaccinationCalendar;

	@ManyToMany
	@Cascade(CascadeType.ALL)
	private List<Appointment> appointment;
	
	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public VaccinationHistoric(int id, String comments, List<Appointment> appointment) {
		super();
		this.id = id;
		this.comments = comments;
		this.appointment = new ArrayList<>();
	}

	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}
}
