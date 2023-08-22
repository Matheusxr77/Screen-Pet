package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccineException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccineException;

public interface InterfaceRegisterVaccine {
	Vaccine findVaccine(String name) throws DoesNotExistVaccineException;
	Vaccine saveVaccine(Vaccine entity) throws DuplicateVaccineException, DoesNotExistVaccineException;
	List<Vaccine> listVaccines();
	boolean checkExistenceVaccineId(Long id);
	Vaccine findVaccineId(Long id);
	void removeVaccine(Long id) throws DoesNotExistVaccineException;
}