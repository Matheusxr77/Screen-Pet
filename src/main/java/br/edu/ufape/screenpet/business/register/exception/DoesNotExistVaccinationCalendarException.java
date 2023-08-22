package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DoesNotExistVaccinationCalendarException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DoesNotExistVaccinationCalendarException(Date date) {
		super("Não existe no sistema um calendário de vacinação com a data informada!");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}