package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTreatmentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTreatmentException;

public interface InterfaceRegisterTreatment {
	Treatment findTreatment(Date date) throws DoesNotExistTreatmentException;
	Treatment saveTreatment(Treatment entity) throws DoesNotExistTreatmentException, DuplicateTreatmentException;
	List<Treatment> listTreatments();
	boolean checkExistenceTreatmentId(Long id);
	Treatment findTreatmentId(Long id);
}