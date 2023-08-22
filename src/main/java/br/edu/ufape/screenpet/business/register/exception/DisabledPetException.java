package br.edu.ufape.screenpet.business.register.exception;

public class DisabledPetException extends Exception {
	private static final long serialVersionUID = 1L;
	private boolean active;
	
	public DisabledPetException(boolean active) {
		super("Não é possível desativar um Pet que já está desativado!");
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
}