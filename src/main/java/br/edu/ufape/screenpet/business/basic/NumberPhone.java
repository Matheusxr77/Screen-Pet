package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NumberPhone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int ddd;
	private int number;

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public NumberPhone(long id, int ddd, int number) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
	}
}