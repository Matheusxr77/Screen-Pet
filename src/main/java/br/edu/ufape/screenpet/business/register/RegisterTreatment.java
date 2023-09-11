package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTreatmentException;
import br.edu.ufape.screenpet.data.InterfaceCollectionTreatment;

@Service
public class RegisterTreatment implements InterfaceRegisterTreatment {
	
	@Autowired
	private InterfaceCollectionTreatment collectionTreatment;

	public Treatment findTreatment(Date date) throws DoesNotExistTreatmentException {
		Treatment treatment = collectionTreatment.findByDate(date);
		if(treatment == null) {
			throw new DoesNotExistTreatmentException(date);
		}
		return treatment;
	}

	public Treatment saveTreatment(Treatment entity) throws DoesNotExistTreatmentException {
		try {
			findTreatment(entity.getDate());
			entity.getDate();
		} catch(DoesNotExistTreatmentException err) {
			return collectionTreatment.save(entity);
		}
		return entity;
	}

	public List<Treatment> listTreatments() {
		return collectionTreatment.findAll();
	}

	public boolean checkExistenceTreatmentId(Long id) {
		return collectionTreatment.existsById(id);
	}

	public Treatment findTreatmentId(Long id) {
		return collectionTreatment.findById(id).orElse(null);
	}
	
	public void removeTreatment(Long id) throws DoesNotExistTreatmentException {
		collectionTreatment.deleteById(id);
	}
}