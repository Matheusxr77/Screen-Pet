package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationHistoricException;
import br.edu.ufape.screenpet.business.register.exception.VaccinationHistoricDoesNotExistException;

public interface InterfaceRegisterVaccinationHistoric {
	VaccinationHistoric findVaccinationHistoric(VaccinationCalendar vaccinationCalendar) throws VaccinationHistoricDoesNotExistException;
	VaccinationHistoric saveVaccinationHistoric(VaccinationHistoric entity)throws VaccinationHistoricDoesNotExistException, DuplicateVaccinationHistoricException;
	List<VaccinationHistoric> listVaccinationHistorics();
	boolean checkExistenceVaccinationHistoricId(Long id);
	VaccinationHistoric findVaccinationHistoricId(Long id);
}