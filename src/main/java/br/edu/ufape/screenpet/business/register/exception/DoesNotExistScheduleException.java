package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DoesNotExistScheduleException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DoesNotExistScheduleException(Date date) {
		super("Não existe no sistema um agendamento com a data informada!");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}