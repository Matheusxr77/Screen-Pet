package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Attendant extends Person {
	
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Schedule> schedules;

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Attendant(String name, String cpf, String gender, Date dateBirth, boolean active,List<Address> address, List<NumberPhone> numberPhone, Usuario usuario, List<Schedule> schedules) {
		super(name, cpf, gender, dateBirth, active, address, numberPhone, usuario);
		this.schedules = schedules;
	}
}