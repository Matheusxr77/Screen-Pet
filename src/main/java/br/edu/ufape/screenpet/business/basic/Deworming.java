package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Deworming extends Medicament {

	private int frequency;
	
	@OneToOne
	private Schedule schedule;

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Deworming(String name, String type, String activeCompound, int dosage, String comments, int frequency) {
		super(name, type, activeCompound, dosage, comments);
		this.frequency = frequency;
	}
}