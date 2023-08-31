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
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String anamnesis;
    private Date date;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Pet pet;

	@OneToOne
    @Cascade(CascadeType.ALL)
    private VaccinationHistoric vaccinationHistoric;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Exam> exams;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Schedule schedule;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Diagnosis diagnosis;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Veterinarian veterinarian;
    
    public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
    
	public VaccinationHistoric getVaccinationHistoric() {
		return vaccinationHistoric;
	}

	public void setVaccinationHistoric(VaccinationHistoric vaccinationHistoric) {
		this.vaccinationHistoric = vaccinationHistoric;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Appointment(String anamnesis, Date date) {
		this.anamnesis = anamnesis;
		this.date = date;
	}
	
	public Appointment() {
	}
}