package br.edu.ufape.screenpet.business.register;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.register.exception.VaccineDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.VaccineDoesNotExistsException;
import br.edu.ufape.screenpet.data.InterfaceCollectionVaccine;

@Service
public class RegisterVaccine implements InterfaceRegisterVaccine {
	@Autowired
	private InterfaceCollectionVaccine collectionVaccine;

	public Vaccine findVaccine(String name) throws VaccineDoesNotExistsException {
		Vaccine vac = collectionVaccine.findByName(name); 
		if(vac == null) {
			throw new VaccineDoesNotExistsException(name);
		}
		return vac;
	}
	
	public Vaccine saveVaccine(Vaccine entity) throws VaccineDoesNotExistsException, VaccineDuplicateException {
		try {
			findVaccine(entity.getName());
			throw new VaccineDuplicateException(entity.getName());
		} catch(VaccineDoesNotExistsException err) {
			return collectionVaccine.save(entity);
		}
	}

	public List<Vaccine> listVaccines() {
		return collectionVaccine.findAll();
	}

	public boolean checkExistenceVaccineId(Long id) {
		return collectionVaccine.existsById(id);
	}

	public Vaccine findVaccineId(Long id) {
		return collectionVaccine.findById(id).orElse(null);
	}

	public void removeVaccine(String name) throws VaccineDoesNotExistsException {
		Vaccine vac = findVaccine(name);
		collectionVaccine.delete(vac);
	}
}