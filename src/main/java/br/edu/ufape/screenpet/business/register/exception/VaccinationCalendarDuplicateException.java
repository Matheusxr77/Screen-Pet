package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class VaccinationCalendarDuplicateException extends Exception{
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public VaccinationCalendarDuplicateException(Date date) {
		super("Não é possível cadastrar dois calendários de vacinação na mesma data.");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}

}
