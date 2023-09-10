package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistDiagnosisException;

public interface InterfaceRegisterDiagnosis {
	Diagnosis findDiagnosis(Pet pet) throws DoesNotExistDiagnosisException;
	Diagnosis saveDiagnosis(Diagnosis entity) throws DoesNotExistDiagnosisException;
	List<Diagnosis> listDiagnosis();
	boolean checkExistenceDiagnosisId(Long id);
	Diagnosis findDiagnosisId(Long id);
	void removeDiagnosis(Long id) throws DoesNotExistDiagnosisException;
}