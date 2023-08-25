package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class DoesNotExistTreatmentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public DoesNotExistTreatmentException(Date date) {
		super("Não existe um Pet no sistema que possua esse registro de vacina em seu calendário!");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}