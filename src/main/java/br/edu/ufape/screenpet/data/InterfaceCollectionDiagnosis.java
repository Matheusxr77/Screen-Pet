package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Pet;

@Repository
public interface InterfaceCollectionDiagnosis extends JpaRepository<Diagnosis, Long> {
	Diagnosis findByPet(Pet pet);
}