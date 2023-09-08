package br.edu.ufape.screenpet.business.register.exception;

public class DuplicateVaccineException extends Exception {
    private static final long serialVersionUID = 1L;
    private String name;

    public DuplicateVaccineException(String name) {
        super("Não é possível cadastrar duas vacinas com o mesmo nome!");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
