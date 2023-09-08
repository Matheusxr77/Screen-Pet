package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationCalendarException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationCalendarException;

public interface InterfaceRegisterVaccinationCalendar {
	VaccinationCalendar findVaccinationCalendar(Date date) throws DoesNotExistVaccinationCalendarException;
	VaccinationCalendar saveVaccinationCalendar(VaccinationCalendar entity) throws DuplicateVaccinationCalendarException, DoesNotExistVaccinationCalendarException;
	List<VaccinationCalendar> listVaccinationCalendar();
	boolean checkExistenceVaccinationCalendarId(Long id);
	VaccinationCalendar findVaccinationCalendarId(Long id);
	void removeVaccinationCalendar(Long id) throws DoesNotExistVaccinationCalendarException;
}