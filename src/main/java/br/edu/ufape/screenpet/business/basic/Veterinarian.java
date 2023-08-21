package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinarian extends Person {
    private int crmv;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Appointment> appointments;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Diagnosis> diagnosis;
    
    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Schedule> schedules;
    
    public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
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

	public Veterinarian(long id, String name, String cpf, String gender, Date dateBirth, boolean active,
			List<Address> address, List<NumberPhone> numberPhone, User user, int crmv, List<Appointment> appointments,
			List<Diagnosis> diagnosis, List<Schedule> schedules) {
		super(id, name, cpf, gender, dateBirth, active, address, numberPhone, user);
		this.crmv = crmv;
		this.appointments = appointments;
		this.diagnosis = diagnosis;
		this.schedules = new ArrayList<>();
	}
}