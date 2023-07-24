package br.com.springboot.springboot.exception;

public class RegraNegocioExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraNegocioExecption(String mensagem) {
		
		super(mensagem);
	}
}
