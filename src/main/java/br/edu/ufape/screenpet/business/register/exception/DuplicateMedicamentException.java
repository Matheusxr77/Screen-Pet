package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Treatment;

public class DuplicateMedicamentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Treatment treatment;
	
	public DuplicateMedicamentException(Treatment treatment) {
		super("Não é possível cadastrar dois medicamentos iguais para o mesmo tratamento!");
		this.treatment = treatment;
	}
	
	public Treatment getTreatment() {
		return this.treatment;
	}
}