package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

public class DuplicateVaccinationHistoricException extends Exception {
	private static final long serialVersionUID = 1L;
	private VaccinationCalendar vaccinationCalendar;
	
	public DuplicateVaccinationHistoricException(VaccinationCalendar vaccinationCalendar) {
		super("Não é possível cadastrar dois históricos de vacina iguais para o mesmo calendário");
		this.vaccinationCalendar = vaccinationCalendar;
	}
	
	public VaccinationCalendar getVaccinationCalendar() {
		return this.vaccinationCalendar;
	}
}