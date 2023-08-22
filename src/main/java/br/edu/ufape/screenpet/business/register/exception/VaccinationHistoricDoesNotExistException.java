package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

public class VaccinationHistoricDoesNotExistException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private VaccinationCalendar vaccinationCalendar;
	
	public VaccinationHistoricDoesNotExistException(VaccinationCalendar vaccinationCalendar) {
		super("Não existe Pet no sistema que possua esse registro de vacina em seu calendário");
		this.vaccinationCalendar = vaccinationCalendar;
	}
	
	public VaccinationCalendar getVaccinationCalendar() {
		return this.vaccinationCalendar;
	}

}
