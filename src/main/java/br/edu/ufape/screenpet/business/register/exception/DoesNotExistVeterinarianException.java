package br.edu.ufape.screenpet.business.register.exception;

public class DoesNotExistVeterinarianException extends Exception {
	private static final long serialVersionUID = 1L;
	private int crmv;
	
	public DoesNotExistVeterinarianException(int crmv) {
		super("Não existe no sistema um veterinário com o CRMV informado!");
		this.crmv = crmv;
	}
	
	public int getCrmv() {
		return this.crmv;
	}
}