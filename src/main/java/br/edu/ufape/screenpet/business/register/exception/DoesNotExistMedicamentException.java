package br.edu.ufape.screenpet.business.register.exception;

public class DoesNotExistMedicamentException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String activeCompound;
	
	public DoesNotExistMedicamentException(String activeCompound) {
		super("Não existe no sistema um medicamento com o composto ativo informado!");
		this.activeCompound = activeCompound;
	}
	
	public String getActiveCompound() {
		return this.activeCompound;
	}
}