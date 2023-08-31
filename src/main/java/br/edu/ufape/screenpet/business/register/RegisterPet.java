package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionPet;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicatePetException;
import br.edu.ufape.screenpet.business.register.exception.DisabledPetException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistPetException;

@Service
public class RegisterPet implements InterfaceRegisterPet {
	@Autowired
	private InterfaceCollectionPet collectionPet;
	
	public Pet findPet(Tutor tutor) throws DoesNotExistPetException {
		Pet p = collectionPet.findByTutor(tutor); 
		if(p == null) {
			throw new DoesNotExistPetException(tutor);
		}
		return p;
	}
	
	public Pet savePet(Pet entity) throws DuplicatePetException {
		try {
			findPet(entity.getTutor());
			throw new DuplicatePetException(entity.getTutor());
		} catch(DoesNotExistPetException err) {
			return collectionPet.save(entity);
		}
	}
	
	public Pet updatePet(Pet entity) throws DoesNotExistPetException {
		try {
			findPet(entity.getTutor());
			return collectionPet.save(entity);
		} catch(DoesNotExistPetException err) {
			throw new DoesNotExistPetException(entity.getTutor());
		}
	}
	
	public List<Pet> listPets() {
		return collectionPet.findAll();
	}
	
	public boolean checkPetExistence(Long id) {
		return collectionPet.existsById(id);
	}
	
	public Pet findPetId(Long id) {
		return collectionPet.findById(id).orElse(null);
	}
	
	public void deactivatePet(Long id) throws DoesNotExistPetException, DisabledPetException {
		Pet u = findPetId(id);
		u.setActive(false);
	}
}