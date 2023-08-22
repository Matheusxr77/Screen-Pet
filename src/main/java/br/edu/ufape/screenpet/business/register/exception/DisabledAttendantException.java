package br.edu.ufape.screenpet.business.register.exception;

public class DisabledAttendantException extends Exception {
	private static final long serialVersionUID = 1L;
	private boolean active;
	
	public DisabledAttendantException(boolean active) {
		super("Não é possível desativar um atendente que já está desativado!");
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
}