package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistExamException;

@RestController
@RequestMapping("/api/v4")
public class ExamController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/exame")
	public List<Exam> listExams() {
		return front.listExams();
	}
	
	@PostMapping("/exame")
	public Exam registerExam(@RequestBody Exam exam) throws DoesNotExistExamException {
		return front.saveExam(exam);
	}
	
	@GetMapping("/exame/{id}")
	public Exam printExam(@PathVariable long id) {
		return front.findExamId(id);
	}
	
	@PatchMapping("/exame/{id}")
	public Exam updateExam(@PathVariable long id, @RequestBody Exam exam) throws DoesNotExistExamException {
		exam.setId(id);
		return front.saveExam(exam);
	}
	
	@DeleteMapping("/exame/{id}")
	public String deleteExam(@PathVariable long id) throws DoesNotExistExamException {	
		 front.removeExam(id);
		 return "exame deletado!";
	}
}