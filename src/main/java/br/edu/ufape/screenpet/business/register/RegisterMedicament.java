package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionMedicament;
import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistMedicamentException;

@Service
public class RegisterMedicament implements InterfaceRegisterMedicament {
	
	@Autowired
	private InterfaceCollectionMedicament collectionMedicament;

	public Medicament findMedicament(Treatment treatment) throws DoesNotExistMedicamentException {
		Medicament medicament = collectionMedicament.findByTreatment(treatment); 
		if(medicament == null) {
			throw new DoesNotExistMedicamentException(treatment);
		}
		return medicament;
	}
	
	public Medicament saveMedicament(Medicament entity) throws DoesNotExistMedicamentException, DuplicateMedicamentException {
		try {
			findMedicament(entity.getTreatment());
			throw new DuplicateMedicamentException(entity.getTreatment());
		} catch(DoesNotExistMedicamentException err) {
			return collectionMedicament.save(entity);
		}
	}

	public List<Medicament> listMedicaments() {
		return collectionMedicament.findAll();
	}

	public boolean checkExistenceMedicamentId(Long id) {
		return collectionMedicament.existsById(id);
	}

	public Medicament findMedicamentId(Long id) {
		return collectionMedicament.findById(id).orElse(null);
	}

	public void removeMedicament(Long id) throws DoesNotExistMedicamentException {
		Medicament medicament = findMedicamentId(id);
		collectionMedicament.delete(medicament);
	}
}