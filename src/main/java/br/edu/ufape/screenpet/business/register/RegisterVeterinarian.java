package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;
import br.edu.ufape.screenpet.business.register.exception.DisabledVeterinarianException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVeterinarianException;
import br.edu.ufape.screenpet.data.InterfaceCollectionVeterinarian;

@Service
public class RegisterVeterinarian implements InterfaceRegisterVeterinarian {
	@Autowired
	private InterfaceCollectionVeterinarian collectionVeterinarian;
	
	public Veterinarian findByCrmv(int crmv) throws DoesNotExistVeterinarianException {
		Veterinarian v = collectionVeterinarian.findByCrmv(crmv);
		if (v == null) {
			throw new DoesNotExistVeterinarianException(crmv);
		}
		return v;
	}
	
	public Veterinarian saveVeterinarian (Veterinarian entity) throws DuplicateVeterinarianException {
		try {
			findByCrmv(entity.getCrmv());
			throw new DuplicateVeterinarianException(entity.getCrmv());
		} catch(DoesNotExistVeterinarianException err) {
			return collectionVeterinarian.save(entity);
		}
	}
	
	public Veterinarian updateVeterinarian(Veterinarian entity) throws DoesNotExistVeterinarianException {
		try {
			findByCrmv(entity.getCrmv());
			return collectionVeterinarian.save(entity);
		} catch(DoesNotExistVeterinarianException err) {
			throw new DoesNotExistVeterinarianException(entity.getCrmv());
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
	
	public void removeByCrmv(int crmv) throws DoesNotExistVeterinarianException {
		Veterinarian v = findByCrmv(crmv);
		collectionVeterinarian.delete(v);
	}
	
	public void deactivateVeterinarian(int crmv) throws DoesNotExistVeterinarianException, DisabledVeterinarianException {
		Veterinarian veterinarian = findByCrmv(crmv);
		veterinarian.setActive(false);
	}
}