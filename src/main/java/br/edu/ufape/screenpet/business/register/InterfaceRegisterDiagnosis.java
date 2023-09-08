package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistDiagnosisException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateDiagnosisException;

public interface InterfaceRegisterDiagnosis {
	Diagnosis findDiagnosis(Pet pet) throws DoesNotExistDiagnosisException;
	Diagnosis saveDiagnosis(Diagnosis entity) throws DoesNotExistDiagnosisException, DuplicateDiagnosisException;
	List<Diagnosis> listDiagnosis();
	boolean checkExistenceDiagnosisId(Long id);
	Diagnosis findDiagnosisId(Long id);
	void removeDiagnosis(Long id) throws DoesNotExistDiagnosisException;
}