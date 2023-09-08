package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionPet;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicatePetException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistPetException;

@Service
public class RegisterPet implements InterfaceRegisterPet {
	
	@Autowired
	private InterfaceCollectionPet collectionPet;
	
	public Pet findPet(Tutor tutor) throws DoesNotExistPetException {
		Pet pet = collectionPet.findByTutor(tutor); 
		if(pet == null) {
			throw new DoesNotExistPetException(tutor);
		}
		return pet;
	}
	
	public Pet savePet(Pet entity) throws DuplicatePetException, DoesNotExistPetException {
		try {
			findPet(entity.getTutor());
			throw new DuplicatePetException(entity.getTutor());
		} catch(DoesNotExistPetException err) {
			return collectionPet.save(entity);
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
	
	public void removePet(Long id) throws DoesNotExistPetException {
		collectionPet.deleteById(id);
	}
}