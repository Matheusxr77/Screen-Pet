package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.register.exception.VaccineDoesNotExistsException;
import br.edu.ufape.screenpet.business.register.exception.VaccineDuplicateException;

public interface InterfaceRegisterVaccine {
	Vaccine findVaccine(String name) throws VaccineDoesNotExistsException;
	Vaccine saveVaccine(Vaccine entity) throws VaccineDuplicateException, VaccineDoesNotExistsException;
	List<Vaccine> listVaccines();
	boolean checkExistenceVaccineId(Long id);
	Vaccine findVaccineId(Long id);
	void removeVaccine(String name) throws VaccineDoesNotExistsException;
}