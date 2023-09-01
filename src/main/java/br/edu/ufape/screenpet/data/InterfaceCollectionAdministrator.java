package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Administrator;

@Repository
public interface InterfaceCollectionAdministrator extends JpaRepository<Administrator, Long> {

}