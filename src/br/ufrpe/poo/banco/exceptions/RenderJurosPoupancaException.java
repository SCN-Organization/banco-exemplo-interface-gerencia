package br.ufrpe.poo.banco.exceptions;

/**
 * Excessao que representa um erro no metodo reder juros de conta poupanca.
 * 
 * @author
 * 
 */
public class RenderJurosPoupancaException extends Exception {

	private static final long serialVersionUID = 1L;

	public RenderJurosPoupancaException() {
		super("Erro ao render juros, o numero informado nao e de uma Poupanca!");
	}
}
