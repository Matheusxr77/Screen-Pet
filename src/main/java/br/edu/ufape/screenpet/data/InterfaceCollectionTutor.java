package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Tutor;

@Repository
public interface InterfaceCollectionTutor extends JpaRepository<Tutor, Long>{
	Tutor findByCpf(String cpf);
}