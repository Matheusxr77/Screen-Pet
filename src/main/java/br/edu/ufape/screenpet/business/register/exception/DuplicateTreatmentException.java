package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DuplicateTreatmentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DuplicateTreatmentException(Date date) {
		super("Não é possível cadastrar dois tratamentos iguais para o mesmo diagnóstico!");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}