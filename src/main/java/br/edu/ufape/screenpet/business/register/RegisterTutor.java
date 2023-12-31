package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionTutor;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTutorException;

@Service
public class RegisterTutor implements InterfaceRegisterTutor {
	
	@Autowired
	private InterfaceCollectionTutor collectionTutor;
	
	public Tutor findTutorCpf(String cpf) throws DoesNotExistTutorException {
		Tutor tutor = collectionTutor.findByCpf(cpf); 
		if(tutor == null) {
			throw new DoesNotExistTutorException(cpf);
		}
		return tutor;
	}
	
	public Tutor saveTutor(Tutor entity) throws DuplicateTutorException, DoesNotExistTutorException {
		try {
			findTutorCpf(entity.getCpf());
			throw new DuplicateTutorException(entity.getCpf());
		} catch(DoesNotExistTutorException err) {
			return collectionTutor.save(entity);
		}
	}
	
	public List<Tutor> listTutor() {
		return collectionTutor.findAll();
	}
	
	public boolean checkTutorExistence(Long id) {
		return collectionTutor.existsById(id);
	}
	
	public Tutor findTutorId(Long id) {
		return collectionTutor.findById(id).orElse(null);
	}
	
	public void removeTutor(String cpf) throws DoesNotExistTutorException {
		Tutor tutor = findTutorCpf(cpf);
		collectionTutor.delete(tutor);
	}
}