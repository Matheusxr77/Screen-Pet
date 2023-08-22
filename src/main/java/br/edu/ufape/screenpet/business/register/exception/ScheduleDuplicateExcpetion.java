package br.edu.ufape.screenpet.business.register.exception;

import java.util.Date;

public class ScheduleDuplicateExcpetion extends Exception{
	private static final long serialVersionUID = 1L;
	private Date date;
	
	public ScheduleDuplicateException(Date date) {
		super("Não é possível cadastrar dois agendamentos na mesma data.");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}

}
