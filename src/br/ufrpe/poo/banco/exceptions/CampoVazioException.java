package br.ufrpe.poo.banco.exceptions;

/**
 * Excessao que representa um erro ao submeter um campo de texto vazio.
 * 
 * @author JoaoOtavio
 * 
 */
public class CampoVazioException extends Exception {

	private static final long serialVersionUID = 1L;

	public CampoVazioException(String valor) {
		super("O campo " + valor + " nao foi preenchido!");
	}

}
