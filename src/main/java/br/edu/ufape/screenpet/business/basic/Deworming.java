package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;

@Entity
public class Deworming extends Medicament {
	private int frequency;
    private String comments;
    
    public Deworming() {
    	
    }

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
