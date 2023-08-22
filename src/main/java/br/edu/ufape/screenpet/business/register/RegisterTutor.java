package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;
import br.edu.ufape.screenpet.business.register.exception.TutorDoesNotExistException;
import br.edu.ufape.screenpet.data.InterfaceCollectionTutor;

public class RegisterTutor {
	@Autowired
	private InterfaceCollectionTutor collectionTutor;
	
	public Tutor findTutorCpf(String cpf) throws TutorDoesNotExistException {
		Tutor tutor = collectionTutor.findByCpf(cpf); 
		if(tutor == null) {
			throw new TutorDoesNotExistException(cpf);
		}
		return tutor;
	}
	
	public Tutor saveTutor(Tutor entity) throws DuplicateTutorException {
		try {
			findTutorCpf(entity.getCpf());
			throw new DuplicateTutorException(entity.getCpf());
		} catch(TutorDoesNotExistException err) {
			return collectionTutor.save(entity);
		}
	}
	
	public Tutor updateTutor(Tutor entity) throws TutorDoesNotExistException {
		try {
			findTutorCpf(entity.getCpf());
			return collectionTutor.save(entity);
		} catch(TutorDoesNotExistException err) {
			throw new TutorDoesNotExistException(entity.getCpf());
		}
	}
	
	public List<Tutor> listTutor() {
		return collectionTutor.findAll();
	}
	
	public boolean checkUserExistence(Long id) {
		return collectionTutor.existsById(id);
	}
	
	public Tutor findTutorId(Long id) {
		return collectionTutor.findById(id).orElse(null);
	}
	
	public void deactivateTutor(String cpf) throws TutorDoesNotExistException {
		Tutor tutor = findTutorCpf(cpf);
		tutor.setActive(false);
	}
}
