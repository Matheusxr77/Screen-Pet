package br.edu.ufape.screenpet.business.register.exception;

public class DoesNotExistMedicamentException extends Exception {
	private static final long serialVersionUID = 1L;
	private String activeCompound;
	
	public DoesNotExistMedicamentException(String activeCompound) {
		super("Não existe no sistema um medicamento nesse tratamento!");
		this.activeCompound = activeCompound;
	}
	
	public String getActiveCompound() {
		return activeCompound;
	}
}