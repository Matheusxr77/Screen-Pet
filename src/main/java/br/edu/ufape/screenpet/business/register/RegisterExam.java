package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistExamException;
import br.edu.ufape.screenpet.data.InterfaceCollectionExam;

@Service
public class RegisterExam implements InterfaceRegisterExam {
	
	@Autowired
	private InterfaceCollectionExam collectionExam;
	
	public Exam findExam(Pet pet) throws DoesNotExistExamException {
		Exam exam = collectionExam.findByPet(pet); 
		if(exam == null) {
			throw new DoesNotExistExamException(pet);
		}
		return exam;
	}
	
	public Exam saveExam(Exam entity) throws DoesNotExistExamException {
		try {
			findExam((Pet) entity.getPet());
			entity.getPet();
		} catch(DoesNotExistExamException err) {
			return collectionExam.save(entity);
		}
		return entity;
	}

	public List<Exam> listExams() {
		return collectionExam.findAll();
	}

	public boolean checkExistenceExamId(Long id) {
		return collectionExam.existsById(id);
	}

	public Exam findExamId(Long id) {
		return collectionExam.findById(id).orElse(null);
	}
	
	public void removeExam(Long id) throws DoesNotExistExamException {
		collectionExam.deleteById(id);
	}
}