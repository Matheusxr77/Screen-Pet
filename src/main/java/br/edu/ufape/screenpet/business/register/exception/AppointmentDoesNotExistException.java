package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class AppointmentDoesNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public AppointmentDoesNotExistException(Date date) {
		super("Não existe no sistema uma consulta com o composto ativo informado");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}

}
