package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.VaccinationCalendarDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.VaccinationCalendarNotExistsException;

public interface InterfaceRegisterVaccinationCalendar {
	VaccinationCalendar findVaccinationCalendar(Date date) throws VaccinationCalendarNotExistsException;
	VaccinationCalendar saveVaccinationCalendar(VaccinationCalendar entity) throws VaccinationCalendarDuplicateException, VaccinationCalendarNotExistsException;
	List<VaccinationCalendar> listVaccinationCalendar();
	boolean checkExistenceVaccinationCalendarId(Long id);
	VaccinationCalendar findVaccinationCalendarId(Long id);
	void removeVaccinationCalendar(Date date) throws VaccinationCalendarNotExistsException;
}