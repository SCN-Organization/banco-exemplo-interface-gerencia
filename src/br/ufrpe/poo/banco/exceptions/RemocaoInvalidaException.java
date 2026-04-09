package br.ufrpe.poo.banco.exceptions;

/**
 * Excessao que representa um erro na remocao de uma conta de uma cliente que so
 * possui a propria conta a ser removida como unica conta.
 * 
 * @author JoaoOtavio
 * 
 */
public class RemocaoInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public RemocaoInvalidaException() {
		super(
				"A remocao nao pode ser concluida! O cliente so possui esta conta!");
	}

}
