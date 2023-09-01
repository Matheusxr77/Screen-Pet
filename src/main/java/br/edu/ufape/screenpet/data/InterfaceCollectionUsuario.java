package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Usuario;

@Repository
public interface InterfaceCollectionUsuario extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}