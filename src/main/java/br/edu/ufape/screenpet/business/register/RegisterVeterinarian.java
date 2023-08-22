package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.VeterinarianDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.VeterinarianNotExistsException;
import br.edu.ufape.screenpet.data.InterfaceCollectionVeterinarian;

@Service
public class RegisterVeterinarian implements InterfaceRegisterVeterinarian{
	@Autowired
	private InterfaceCollectionVeterinarian collectionVeterinarian;
	
	public Veterinarian findByCrmv(int crmv) throws VeterinarianNotExistsException{
		Veterinarian v = collectionVeterinarian.findByCrmv(crmv);
		if (v == null) {
			throw new VeterinarianNotExistsException(crmv);
		}
		return v;
	}
	
	public Veterinarian saveVeterinarian (Veterinarian entity) throws VeterinarianDuplicateException{
		try {
			findByCrmv(entity.getCrmv());
			throw new VeterinarianDuplicateException(entity.getCrmv());
		} catch(VeterinarianNotExistsException err) {
			return collectionVeterinarian.save(entity);
		}
	}
	
	public Veterinarian updateVeterinarian(Veterinarian entity) throws VeterinarianNotExistsException{
		try {
			findByCrmv(entity.getCrmv());
			return collectionVeterinarian.save(entity);
		} catch(VeterinarianNotExistsException err) {
			throw new VeterinarianNotExistsException(entity.getCrmv());
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
	
	public void removeByCrmv(int crmv) throws VeterinarianNotExistsException {
		Veterinarian v = findByCrmv(crmv);
		collectionVeterinarian.delete(v);
	}
	
	public void removeVeterinarianId(Long id) throws VeterinarianNotExistsException {
		Veterinarian v = findVeterinarianId(id);
		collectionVeterinarian.delete(v);
	}

}
