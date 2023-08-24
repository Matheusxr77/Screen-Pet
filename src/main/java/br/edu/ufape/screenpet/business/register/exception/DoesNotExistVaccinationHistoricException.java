package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

public class DoesNotExistVaccinationHistoricException extends Exception {
	private static final long serialVersionUID = 1L;
	private VaccinationCalendar vaccinationCalendar;
	
	public DoesNotExistVaccinationHistoricException(VaccinationCalendar vaccinationCalendar) {
		super("Não existe um Pet no sistema que possua esse registro de vacina em seu calendário!");
		this.vaccinationCalendar = vaccinationCalendar;
	}
	
	public VaccinationCalendar getVaccinationCalendar() {
		return this.vaccinationCalendar;
	}
}