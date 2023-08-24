package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DuplicateAppointmentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DuplicateAppointmentException(Date date) {
		super("Não é possível cadastrar duas consultas no mesmo dia e horário");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}