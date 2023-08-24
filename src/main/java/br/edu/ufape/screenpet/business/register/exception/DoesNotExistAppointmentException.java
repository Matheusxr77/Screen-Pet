package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DoesNotExistAppointmentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DoesNotExistAppointmentException(Date date) {
		super("Não existe no sistema uma consulta com a data informada!");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}