package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Vaccine;

@Repository
public interface InterfaceCollectionVaccine extends JpaRepository<Vaccine, Long> {
	Vaccine findByName(String name);
}