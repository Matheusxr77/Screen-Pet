package br.edu.ufape.screenpet.business.register.exception;

public class PetDuplicateException extends Exception{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public PetDuplicateException(String name) {
		super("Não é possível cadastrar dois pets com o mesmo nome");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
