package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.MedicamentDoesNotExistException;

public interface InterfaceRegisterVaccinationHistoric {
	
	VaccinationHistoric findVaccinationHistoric(String activeCompound) throws VaccinationHistoricDoesNotExistException;

	VaccinationHistoric saveMedicament(VaccinationHistoric entity) throws DuplicateVaccinationHistoricException, VaccinationHistoricDoesNotExistException;

	List<VaccinationHistoric> listVaccinationHistorics();

	boolean checkExistenceVaccinationHistoricId(Long id);

	VaccinationHistoric findVaccinationHistoricId(Long id);
}
