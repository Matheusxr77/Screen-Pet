package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.Treatment;

@Repository
public interface InterfaceCollectionMedicament extends JpaRepository<Medicament, Long> {
	Medicament findByTreatment(Treatment treatment);
}