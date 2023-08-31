package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Pet;

public class DuplicateExamException extends Exception {
	private static final long serialVersionUID = 1L;
	private Pet pet;
	
	public DuplicateExamException(Pet pet) {
		super("Não é possível cadastrar dois exames iguais para o mesmo pet!");
		this.pet = pet;
	}
	
	public Pet getPet() {
		return this.pet;
	}
}