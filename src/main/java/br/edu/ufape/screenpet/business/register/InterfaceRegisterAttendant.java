package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAttendantException;

public interface InterfaceRegisterAttendant {
	Attendant findAttendantCpf(String cpf) throws DoesNotExistAttendantException;
	Attendant saveAttendant(Attendant entity) throws DuplicateAttendantException, DoesNotExistAttendantException;
	List<Attendant> listAttendant();
	boolean checkAttendantExistence(Long id);
	Attendant findAttendantId(Long id);
	void removeAttendantCpf(String cpf) throws DoesNotExistAttendantException;
}