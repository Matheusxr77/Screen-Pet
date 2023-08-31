package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Tutor;

public class DuplicatePetException extends Exception {
	private static final long serialVersionUID = 1L;
	private Tutor tutor;
	
	public DuplicatePetException(Tutor tutor) {
		super("Não é possível cadastrar dois pets iguais para o mesmo tutor!");
		this.tutor = tutor;
	}
	
	public Tutor getTutor() {
		return this.tutor;
	}
}