package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Medicament;

@Repository
public interface InterfaceColecaoMedicament extends JpaRepository<Medicament, Long>{

}
