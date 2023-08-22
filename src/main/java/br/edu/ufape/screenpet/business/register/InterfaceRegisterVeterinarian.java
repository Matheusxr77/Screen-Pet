package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.VeterinarianDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.VeterinarianNotExistsException;

public interface InterfaceRegisterVeterinarian {
	Veterinarian findByCrmv(int crmv) throws VeterinarianNotExistsException;
	Veterinarian saveVeterinarian(Veterinarian entity) throws VeterinarianDuplicateException;
	Veterinarian updateVeterinarian(Veterinarian entity) throws VeterinarianNotExistsException;
	List<Veterinarian> listVeterinarian();
	boolean checkVeterinarianExistence(Long id);
	Veterinarian findVeterinarianId(Long id);
	void removeVeterinarianId(Long id) throws VeterinarianNotExistsException;
}
