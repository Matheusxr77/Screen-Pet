package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.basic.Veterinarian;

@Repository
public interface InterfaceCollectionVeterinarian extends JpaRepository<Veterinarian, Long> {
	Veterinarian findByCrmv(int crmv);
}
