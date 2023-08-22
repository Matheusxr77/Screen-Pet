package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionTreatment;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTreatmentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTreatmentException;

@Service
public class RegisterTreatment {
	@Autowired
	private InterfaceCollectionTreatment collectionTreatment;
	
	public Treatment findTreatment(Diagnosis diagnosis) throws DoesNotExistTreatmentException {
		Treatment treatment = collectionTreatment.findByDiagnosis(diagnosis); 
		if(treatment == null) {
			throw new DoesNotExistTreatmentException(diagnosis);
		}
		return treatment;
	}
	
	public Treatment saveTreatment(Treatment entity) throws DoesNotExistTreatmentException, DuplicateTreatmentException {
		try {
			findTreatment(entity.getDiagnosis());
			throw new DuplicateTreatmentException(entity.getDiagnosis());
		} catch(DoesNotExistTreatmentException err) {
			return collectionTreatment.save(entity);
		}
	}

	public List<Treatment> listTreatments() {
		return collectionTreatment.findAll();
	}

	public boolean checkExistenceTreatmentId(Long id) {
		return collectionTreatment.existsById(id);
	}

	public Treatment findTreatmenId(Long id) {
		return collectionTreatment.findById(id).orElse(null);
	}
}