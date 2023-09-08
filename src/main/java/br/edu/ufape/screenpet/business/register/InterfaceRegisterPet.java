package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicatePetException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistPetException;

public interface InterfaceRegisterPet {
	Pet findPet(Tutor tutor) throws DoesNotExistPetException;
	Pet savePet(Pet entity) throws DuplicatePetException, DoesNotExistPetException;
	List<Pet> listPets();
	boolean checkPetExistence(Long id);
	Pet findPetId(Long id);
	void removePet(Long id) throws DoesNotExistPetException;
}