package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionPet;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.DuplicatePetException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistPetException;

@Service
public class RegisterPet implements InterfaceRegisterPet {
	@Autowired
	private InterfaceCollectionPet collectionPet;
	
	public Pet findPetName(String name) throws DoesNotExistPetException {
		Pet p = collectionPet.findByName(name); 
		if(p == null) {
			throw new DoesNotExistPetException(name);
		}
		return p;
	}
	
	public Pet savePet(Pet entity) throws DuplicatePetException {
		try {
			findPetName(entity.getName());
			throw new DuplicatePetException(entity.getName());
		} catch(DoesNotExistPetException err) {
			return collectionPet.save(entity);
		}
	}
	
	public Pet updatePet(Pet entity) throws DoesNotExistPetException {
		try {
			findPetName(entity.getName());
			return collectionPet.save(entity);
		} catch(DoesNotExistPetException err) {
			throw new DoesNotExistPetException(entity.getName());
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
	
	public void removePetId(Long id) throws DoesNotExistPetException {
		Pet u = findPetId(id);
		collectionPet.delete(u);
	}
}