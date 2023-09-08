package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistExamException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateExamException;

public interface InterfaceRegisterExam {
	Exam findExam(Pet pet) throws DoesNotExistExamException;
	Exam saveExam(Exam entity) throws DoesNotExistExamException, DuplicateExamException;
	List<Exam> listExams();
	boolean checkExistenceExamId(Long id);
	Exam findExamId(Long id);
	void removeExam(Long id) throws DoesNotExistExamException;
}