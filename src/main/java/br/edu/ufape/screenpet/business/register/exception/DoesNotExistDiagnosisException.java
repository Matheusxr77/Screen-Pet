package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Pet;

public class DoesNotExistDiagnosisException extends Exception {
	private static final long serialVersionUID = 1L;
	private Pet pet;
	
	public DoesNotExistDiagnosisException(Pet pet) {
		super("Não existe um diagnóstico no sistema que possua esse pet!");
		this.pet = pet;
	}
	
	public Pet getPet() {
		return this.pet;
	}
}