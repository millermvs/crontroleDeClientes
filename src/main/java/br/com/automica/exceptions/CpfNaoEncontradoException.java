package br.com.automica.exceptions;

public class CpfNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "CPF não encontrado.";
	}

}
