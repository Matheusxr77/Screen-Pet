package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DuplicateScheduleException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DuplicateScheduleException(Date date) {
		super("Não é possível cadastrar dois agendamentos na mesma data e horário!");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}