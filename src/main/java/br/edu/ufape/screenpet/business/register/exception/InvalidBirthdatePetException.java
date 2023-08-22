package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class InvalidBirthdatePetException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date dateBirth;
	
	public InvalidBirthdatePetException(Date dateBirth) {
		super("A data de nascimento informada é inválida");
		this.dateBirth = dateBirth;
	}
	
	public Date getDateBirth() {
		return this.dateBirth;
	}
}
