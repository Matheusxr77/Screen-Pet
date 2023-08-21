package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.MedicamentDoesNotExistException;

public interface InterfaceRegisterMedicament {
	
	Medicament findMedicament(String activeCompound) throws MedicamentDoesNotExistException;

	Medicament saveMedicament(Medicament entity) throws DuplicateMedicamentException, MedicamentDoesNotExistException;

	List<Medicament> listMedicaments();

	boolean checkExistenceMedicamentId(Long id);

	Medicament findMedicamentId(Long id);

	void removeMedicament(String activeCompound) throws MedicamentDoesNotExistException;

}
