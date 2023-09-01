package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinarian extends Person {
    private int crmv;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Schedule> schedules;

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
    
	public Veterinarian(String name, String cpf, String gender, Date birthday, boolean active, int crmv) {
		super(name, cpf, gender, birthday, active);
		this.crmv = crmv;
	}
	
	public Veterinarian() {
		
	}
}