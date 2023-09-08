package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTutorException;

public interface InterfaceRegisterTutor {
	Tutor findTutorCpf(String cpf) throws DoesNotExistTutorException;
	Tutor saveTutor(Tutor entity) throws DuplicateTutorException, DoesNotExistTutorException;
	List<Tutor> listTutor();
	boolean checkTutorExistence(Long id);
	Tutor findTutorId(Long id);
	void removeTutor(String cpf) throws DoesNotExistTutorException;
}