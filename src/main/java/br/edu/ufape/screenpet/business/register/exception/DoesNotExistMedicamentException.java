package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Treatment;

public class DoesNotExistMedicamentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Treatment treatment;
	
	public DoesNotExistMedicamentException(Treatment treatment) {
		super("Não existe no sistema um medicamento nesse tratamento!");
		this.treatment = treatment;
	}
	
	public Treatment getTreatment() {
		return this.treatment;
	}
}