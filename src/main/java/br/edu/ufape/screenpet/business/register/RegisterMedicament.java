package br.edu.ufape.screenpet.business.register;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionMedicament;
import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.MedicamentDoesNotExistException;

@Service
public class RegisterMedicament implements InterfaceRegisterMedicament {
	@Autowired
	private InterfaceCollectionMedicament collectionMedicament;

	
	public Medicament findMedicament(String activeCompound) throws MedicamentDoesNotExistException {
		Medicament med = collectionMedicament.findByActiveCompound(activeCompound); 
		if(med == null) {
			throw new MedicamentDoesNotExistException(activeCompound);
		}
		return med;
	}
	
	public Medicament saveMedicament(Medicament entity)throws MedicamentDoesNotExistException, DuplicateMedicamentException {
		try {
			findMedicament(entity.getActiveCompound());
			throw new DuplicateMedicamentException(entity.getActiveCompound());
		} catch(MedicamentDoesNotExistException err) {
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

	public void removeMedicament(String activeCompound) throws MedicamentDoesNotExistException {
		Medicament med = findMedicament(activeCompound);
		collectionMedicament.delete(med);
	}
}