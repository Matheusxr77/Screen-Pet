package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionVaccine;
import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccineException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccineException;

@Service
public class RegisterVaccine implements InterfaceRegisterVaccine {
	
	@Autowired
	private InterfaceCollectionVaccine collectionVaccine;

	public Vaccine findVaccine(String name) throws DoesNotExistVaccineException {
		Vaccine vaccine = collectionVaccine.findByName(name); 
		if(vaccine == null) {
			throw new DoesNotExistVaccineException(name);
		}
		return vaccine;
	}
	
	public Vaccine saveVaccine(Vaccine entity) throws DoesNotExistVaccineException, DuplicateVaccineException {
		try {
			findVaccine(entity.getName());
			throw new DoesNotExistVaccineException(entity.getName());
		} catch(DoesNotExistVaccineException err) {
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

	public void removeVaccine(Long id) throws DoesNotExistVaccineException {
		collectionVaccine.deleteById(id);
	}
}