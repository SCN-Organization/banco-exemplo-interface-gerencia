package br.ufrpe.poo.banco.exceptions;

/**
 * Excessao que representa um erro caso o sistema tente encontrar uma conta nao
 * cadastrada.
 * 
 * @author JoaoOtavio
 * 
 */
public class ContaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContaNaoEncontradaException() {
		super("Conta nao encontrada!");
	}
}
