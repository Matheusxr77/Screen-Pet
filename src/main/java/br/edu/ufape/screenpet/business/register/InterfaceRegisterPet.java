package br.edu.ufape.screenpet.business.register;

import java.util.List;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.PetDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.PetNotExistsException;

public interface InterfaceRegisterPet {
<<<<<<< HEAD
	Pet findByName(String name) throws PetNotExistsException;
	Pet savePet(Pet entity) throws PetDuplicateException, PetNotExistsException;
=======
	Pet findPetName(String name) throws PetNotExistsException;
	Pet savePet(Pet entity) throws PetDuplicateException;
	public Pet updatePet(Pet entity) throws PetNotExistsException;
>>>>>>> b392f2a093b88cd011508c9d62a8018a0aad363e
	List<Pet> listPets();
	boolean checkPetExistence(Long id);
	Pet findPetId(Long id);
	void removePetId(Long id) throws PetNotExistsException;
}