package br.com.automica.exceptions;

public class CpfJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "CPF já cadastrado no sistema.";
	}
}
