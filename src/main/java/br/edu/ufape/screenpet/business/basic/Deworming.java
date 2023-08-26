package br.edu.ufape.screenpet.business.basic;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Deworming extends Medicament {

	private int frequency;

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Deworming(String name, String type, String activeCompound, int dosage, String comments,	List<Treatment> treatments, int frequency) {
		super(name, type, activeCompound, dosage, comments, treatments);
		this.frequency = frequency;
	}
}