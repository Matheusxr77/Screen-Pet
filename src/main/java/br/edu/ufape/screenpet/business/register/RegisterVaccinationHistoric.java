package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionVaccinationHistoric;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationHistoricException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationHistoricException;

@Service
public class RegisterVaccinationHistoric implements InterfaceRegisterVaccinationHistoric {
	
	@Autowired
	private InterfaceCollectionVaccinationHistoric collectionVaccinationHistoric;
	
	public VaccinationHistoric findVaccinationHistoric(VaccinationCalendar vaccinationCalendar) throws DoesNotExistVaccinationHistoricException {
		VaccinationHistoric vaccinationHistoric = collectionVaccinationHistoric.findByVaccinationCalendar(vaccinationCalendar); 
		if(vaccinationHistoric == null) {
			throw new DoesNotExistVaccinationHistoricException(vaccinationCalendar);
		}
		return vaccinationHistoric;
	}
	
	public VaccinationHistoric saveVaccinationHistoric(VaccinationHistoric entity) throws DoesNotExistVaccinationHistoricException, DuplicateVaccinationHistoricException {
		try {
			findVaccinationHistoric((VaccinationCalendar) entity.getVaccinationCalendar());
			throw new DuplicateVaccinationHistoricException((VaccinationCalendar) entity.getVaccinationCalendar());
		} catch(DoesNotExistVaccinationHistoricException err) {
			return collectionVaccinationHistoric.save(entity);
		}
	}

	public List<VaccinationHistoric> listVaccinationHistorics() {
		return collectionVaccinationHistoric.findAll();
	}

	public boolean checkExistenceVaccinationHistoricId(Long id) {
		return collectionVaccinationHistoric.existsById(id);
	}

	public VaccinationHistoric findVaccinationHistoricId(Long id) {
		return collectionVaccinationHistoric.findById(id).orElse(null);
	}
	
	public void removeVaccinationHistoric(Long id) throws DoesNotExistVaccinationHistoricException {
		collectionVaccinationHistoric.deleteById(id);
	}
}