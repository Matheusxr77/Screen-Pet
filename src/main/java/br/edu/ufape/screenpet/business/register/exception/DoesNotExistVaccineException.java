package br.edu.ufape.screenpet.business.register.exception;

public class DoesNotExistVaccineException extends Exception {
	private static final long serialVersionUID = 1L;
	private String name;
	
	public DoesNotExistVaccineException(String name) {
		super("Não existe no sistema uma vacina com o nome informado!");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}