package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionAttendant;
import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.register.exception.DisabledAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAttendantException;

@Service
public class RegisterAttendant implements InterfaceRegisterAttendant {
	@Autowired
	private InterfaceCollectionAttendant collectionAttendant;
	
	public Attendant findAttendantCpf(String cpf) throws DoesNotExistAttendantException {
		Attendant attendant = collectionAttendant.findByCpf(cpf); 
		if(attendant == null) {
			throw new DoesNotExistAttendantException(cpf);
		}
		return attendant;
	}
	
	public Attendant saveAttendant(Attendant entity) throws DuplicateAttendantException {
		try {
			findAttendantCpf(entity.getCpf());
			throw new DuplicateAttendantException(entity.getCpf());
		} catch(DoesNotExistAttendantException err) {
			return collectionAttendant.save(entity);
		}
	}
	
	public Attendant updateAttendant(Attendant entity) throws DoesNotExistAttendantException {
		try {
			findAttendantCpf(entity.getCpf());
			return collectionAttendant.save(entity);
		} catch(DoesNotExistAttendantException err) {
			throw new DoesNotExistAttendantException(entity.getCpf());
		}
	}
	
	public List<Attendant> listAttendant() {
		return collectionAttendant.findAll();
	}
	
	public boolean checkAttendantExistence(Long id) {
		return collectionAttendant.existsById(id);
	}
	
	public Attendant findAttendantId(Long id) {
		return collectionAttendant.findById(id).orElse(null);
	}
	
	public void deactivateAttendant(String cpf) throws DoesNotExistAttendantException, DisabledAttendantException {
		Attendant attendant = findAttendantCpf(cpf);
		attendant.setActive(false);
	}
}