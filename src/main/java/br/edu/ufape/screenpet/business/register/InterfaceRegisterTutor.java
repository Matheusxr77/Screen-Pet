package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DisabledTutorException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;
import br.edu.ufape.screenpet.business.register.exception.TutorDoesNotExistException;

public interface InterfaceRegisterTutor {
	Tutor findTutorCpf(String cpf) throws TutorDoesNotExistException;
	Tutor saveTutor(Tutor entity) throws DuplicateTutorException;
	Tutor updateTutor(Tutor entity) throws TutorDoesNotExistException;
	List<Tutor> listTutor();
	boolean checkUserExistence(Long id);
	Tutor findTutorId(Long id);
	void deactivateTutor(String cpf) throws TutorDoesNotExistException, DisabledTutorException;
}
