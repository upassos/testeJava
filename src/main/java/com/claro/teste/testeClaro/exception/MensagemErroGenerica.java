package com.claro.teste.testeClaro.exception;

public class MensagemErroGenerica extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public MensagemErroGenerica(String mensagem) {
		super(mensagem);
	}
	
	public MensagemErroGenerica(String message, Throwable causa) {
		super(message, causa);
	}
	
}
