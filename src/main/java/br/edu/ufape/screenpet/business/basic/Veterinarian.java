package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Veterinarian extends Person {
    private int crmv;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Appointment appointment;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Diagnosis> diagnosis;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Schedule> schedules;
    
    public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public List<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public int getCrmv() {
        return crmv;
    }

    public void setCrmv(int crmv) {
        this.crmv = crmv;
    }
    
	public Veterinarian(String name, String cpf, String gender, Date dateBirth, boolean active, int crmv) {
		super(name, cpf, gender, dateBirth, active);
		this.crmv = crmv;
	}
}