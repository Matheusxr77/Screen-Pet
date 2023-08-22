package br.edu.ufape.screenpet.business.register.exception;

public class DisabledUserException extends Exception {
	private static final long serialVersionUID = 1L;
	private boolean active;
	
	public DisabledUserException(boolean active) {
		super("Não é possível desativar um usuário que já está desativado!");
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
}