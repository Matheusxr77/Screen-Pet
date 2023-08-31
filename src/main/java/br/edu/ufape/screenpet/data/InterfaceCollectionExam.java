package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.basic.Pet;

@Repository
public interface InterfaceCollectionExam extends JpaRepository<Exam, Long> {
	Exam findByPet(Pet pet);
}