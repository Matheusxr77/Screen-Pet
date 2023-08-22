package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionPet;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.PetNotExistsException;
import br.edu.ufape.screenpet.business.register.exception.PetDuplicateException;

@Service
public class RegisterPet implements InterfaceRegisterPet {
	@Autowired
	private InterfaceCollectionPet collectionPet;
	
	public Pet findPetName(String name) throws PetNotExistsException {
		Pet p = collectionPet.findByName(name); 
		if(p == null) {
			throw new PetNotExistsException(name);
		}
		return p;
	}
	
	public Pet savePet(Pet entity) throws PetDuplicateException {
		try {
			findPetName(entity.getName());
			throw new PetDuplicateException(entity.getName());
		} catch(PetNotExistsException err) {
			return collectionPet.save(entity);
		}
	}
	
	public Pet updatePet(Pet entity) throws PetNotExistsException {
		try {
			findPetName(entity.getName());
			return collectionPet.save(entity);
		} catch(PetNotExistsException err) {
			throw new PetNotExistsException(entity.getName());
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
	
	public void removePetId(Long id) throws PetNotExistsException {
		Pet u = findPetId(id);
		collectionPet.delete(u);
	}

<<<<<<< HEAD
	@Override
	public boolean checkExistencePetId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removePet(String name) throws PetNotExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet findPetByName(String name) throws PetNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet findByName(String name) throws PetNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}
}
=======
	public void removePetName(String name) throws PetNotExistsException {
		Pet p = findPetName(name);
		collectionPet.delete(p);
	}
}
>>>>>>> b392f2a093b88cd011508c9d62a8018a0aad363e
