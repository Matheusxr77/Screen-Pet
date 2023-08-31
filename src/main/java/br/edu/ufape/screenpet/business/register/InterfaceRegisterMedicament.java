package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistMedicamentException;

public interface InterfaceRegisterMedicament {
	Medicament findMedicament(Treatment treatment) throws DoesNotExistMedicamentException;
	Medicament saveMedicament(Medicament entity) throws DuplicateMedicamentException, DoesNotExistMedicamentException;
	List<Medicament> listMedicaments();
	boolean checkExistenceMedicamentId(Long id);
	Medicament findMedicamentId(Long id);
	void removeMedicament(Long id) throws DoesNotExistMedicamentException;
}