package br.edu.ufape.screenpet.business.register;

import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.PetNotExistsException;

public interface InterfaceRegisterPet {
	Pet findByName(String name) throws PetNotExistsException;
}
