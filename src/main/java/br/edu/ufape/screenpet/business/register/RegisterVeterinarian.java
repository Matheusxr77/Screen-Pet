package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionVeterinarian;
import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVeterinarianException;

@Service
public class RegisterVeterinarian implements InterfaceRegisterVeterinarian {
	
	@Autowired
	private InterfaceCollectionVeterinarian collectionVeterinarian;
	
	public Veterinarian findByCrmv(int crmv) throws DoesNotExistVeterinarianException {
		Veterinarian veterinarian = collectionVeterinarian.findByCrmv(crmv);
		if (veterinarian == null) {
			throw new DoesNotExistVeterinarianException(crmv);
		}
		return veterinarian;
	}
	
	public Veterinarian saveVeterinarian (Veterinarian entity) throws DuplicateVeterinarianException, DoesNotExistVeterinarianException {
		try {
			findByCrmv(entity.getCrmv());
			throw new DuplicateVeterinarianException(entity.getCrmv());
		} catch(DoesNotExistVeterinarianException err) {
			return collectionVeterinarian.save(entity);
		}
	}
	
	public List<Veterinarian> listVeterinarian() {
		return collectionVeterinarian.findAll();
	}
	
	public boolean checkVeterinarianExistence(Long id) {
		return collectionVeterinarian.existsById(id);
	}
	
	public Veterinarian findVeterinarianId(Long id) {
		return collectionVeterinarian.findById(id).orElse(null);
	}
	
	public void removeVeterinarian(int crmv) throws DoesNotExistVeterinarianException {
		Veterinarian veterinarian = findByCrmv(crmv);
		collectionVeterinarian.delete(veterinarian);
	}
}