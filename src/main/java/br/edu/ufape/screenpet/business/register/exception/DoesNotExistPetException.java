package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Tutor;

public class DoesNotExistPetException extends Exception {
	private static final long serialVersionUID = 1L;
	private Tutor tutor;
	
	public DoesNotExistPetException(Tutor tutor) {
		super("Não existe no sistema um pet do tutor informado!");
		this.tutor = tutor;
	}
	
	public Tutor getTutor() {
		return this.tutor;
	}
}