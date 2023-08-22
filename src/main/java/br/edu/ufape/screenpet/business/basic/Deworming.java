package br.edu.ufape.screenpet.business.basic;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Deworming extends Medicament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int frequency;

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Deworming(long id, String name, String type, String activeCompound, int dosage, String comments,	List<Treatment> treatments, int frequency) {
		super(id, name, type, activeCompound, dosage, comments, treatments);
		this.frequency = frequency;
	}
}