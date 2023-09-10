package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistDiagnosisException;
import br.edu.ufape.screenpet.data.InterfaceCollectionDiagnosis;

@Service
public class RegisterDiagnosis implements InterfaceRegisterDiagnosis {
	
	@Autowired
	private InterfaceCollectionDiagnosis collectionDiagnosis;
	
	public Diagnosis findDiagnosis(Pet pet) throws DoesNotExistDiagnosisException {
		Diagnosis diagnosis = collectionDiagnosis.findByPet(pet); 
		if(diagnosis == null) {
			throw new DoesNotExistDiagnosisException(pet);
		}
		return diagnosis;
	}
	
	public Diagnosis saveDiagnosis(Diagnosis entity) throws DoesNotExistDiagnosisException {
		try {
			findDiagnosis((Pet) entity.getPet());
			entity.getPet();
		} catch(DoesNotExistDiagnosisException err) {
			return collectionDiagnosis.save(entity);
		}
		return entity;
	}

	public List<Diagnosis> listDiagnosis() {
		return collectionDiagnosis.findAll();
	}

	public boolean checkExistenceDiagnosisId(Long id) {
		return collectionDiagnosis.existsById(id);
	}

	public Diagnosis findDiagnosisId(Long id) {
		return collectionDiagnosis.findById(id).orElse(null);
	}
	
	public void removeDiagnosis(Long id) throws DoesNotExistDiagnosisException {
		collectionDiagnosis.deleteById(id);
	}
}