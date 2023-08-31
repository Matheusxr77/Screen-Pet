package br.edu.ufape.screenpet.business.basic;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String gender;
	private String breed;
	private String specie;
	private Date dateBirth;
	private boolean active;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private VaccinationCalendar vaccinationCalendar;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Tutor tutor;
	
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}

	public void setVaccinationCalendar(VaccinationCalendar vaccinationCalendar) {
		this.vaccinationCalendar = vaccinationCalendar;
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
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}
	
	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pet(String name, String gender, String breed, String specie, Date dateBirth, boolean active) {
		super();
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.specie = specie;
		this.dateBirth = dateBirth;
		this.active = active;
	}
	
	public Pet() {
		// TODO Auto-generated constructor stub
	}
}