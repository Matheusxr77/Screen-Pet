package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String gender;
	private Date dateBirth;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Schedule> schedules;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private VaccinationCalendar vaccinationCalendar;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Appointment> appointment;
	
	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}

	public void setVaccinationCalendar(VaccinationCalendar vaccinationCalendar) {
		this.vaccinationCalendar = vaccinationCalendar;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Pet(long id, String name, String gender, Date dateBirth, List<Schedule> schedules, VaccinationCalendar vaccinationCalendar, List<Appointment> appointment) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateBirth = dateBirth;
		this.schedules = schedules;
		this.vaccinationCalendar = vaccinationCalendar;
		this.appointment = appointment;
	}
}
