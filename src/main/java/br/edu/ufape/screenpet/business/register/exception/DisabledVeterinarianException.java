package br.edu.ufape.screenpet.business.register.exception;

public class DisabledVeterinarianException extends Exception {
	private static final long serialVersionUID = 1L;
	private boolean active;
	
	public DisabledVeterinarianException(boolean active) {
		super("Não é possível desativar um veterinário que já está desativado!");
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
}