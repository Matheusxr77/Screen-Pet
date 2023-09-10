package br.edu.ufape.screenpet.business.register.exception;

public class DuplicateMedicamentException extends Exception {
	private static final long serialVersionUID = 1L;
	private String activeCompound;
	
	public DuplicateMedicamentException(String activeCompound) {
		super("Não é possível cadastrar dois medicamentos com o mesmo composto ativo!");
		this.activeCompound = activeCompound;
	}
	
	public String getActiveCompound() {
		return activeCompound;
	}
}