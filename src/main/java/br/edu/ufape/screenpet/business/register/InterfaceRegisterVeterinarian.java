package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVeterinarianException;

public interface InterfaceRegisterVeterinarian {
	Veterinarian findByCrmv(int crmv) throws DoesNotExistVeterinarianException;
	Veterinarian saveVeterinarian(Veterinarian entity) throws DuplicateVeterinarianException, DoesNotExistVeterinarianException;
	List<Veterinarian> listVeterinarian();
	boolean checkVeterinarianExistence(Long id);
	Veterinarian findVeterinarianId(Long id);
	void removeVeterinarian(int crmv) throws DoesNotExistVeterinarianException;
}