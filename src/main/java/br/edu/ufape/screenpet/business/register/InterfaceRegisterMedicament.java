package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistMedicamentException;

public interface InterfaceRegisterMedicament {
	Medicament findMedicament(String activeCompound) throws DoesNotExistMedicamentException;
	Medicament saveMedicament(Medicament entity) throws DoesNotExistMedicamentException;
	List<Medicament> listMedicaments();
	boolean checkExistenceMedicamentId(Long id);
	Medicament findMedicamentId(Long id);
	void removeMedicament(Long id) throws DoesNotExistMedicamentException;
}