package br.ufrpe.poo.banco.dados;

import br.ufrpe.poo.banco.exceptions.RepositorioException;
import br.ufrpe.poo.banco.iterator.IteratorContaAbstrata;
import br.ufrpe.poo.banco.negocio.ContaAbstrata;

/**
 * Interface que representa um repositorio de objetos do tipo <code>Conta</code>
 * .
 */
public interface IRepositorioContas {

	/**
	 * Insere uma conta no repositorio.
	 * 
	 * @param conta
	 *            conta a ser inserida.
	 * @return se conta foi inserida no repositorio. Se a conta ja existe no
	 *         repositorio nao sera inserida.
	 * @throws RepositorioException
	 *             levantada quando ocorre erro no repositorio.
	 */
	boolean inserir(ContaAbstrata conta) throws RepositorioException;

	/**
	 * Procura por uma conta do repositorio a partir do seu numero.
	 * 
	 * @param numero
	 *            numero da conta a ser retornada.
	 * @return conta encontrada. Retorna <code>null</code> se a conta nao foi
	 *         encontrada.
	 * @throws RepositorioException
	 *             levantada quando ocorre erro no repositorio.
	 */
	ContaAbstrata procurar(String numero);

	/**
	 * Remove uma conta do repositorio.
	 * 
	 * @param numero
	 *            numero da conta a ser removida.
	 * @return se conta foi removida. Se conta nao existe retorna
	 *         <code>false<code/>.
	 * @throws RepositorioException
	 *             levantada quando ocorre erro no repositorio.
	 */
	boolean remover(String numero) throws RepositorioException;

	/**
	 * Atualiza uma conta no repositorio.
	 * 
	 * @param conta
	 *            conta a ser atualizada.
	 * @return se conta foi atualizada. Se conta nao existe e retornado
	 *         <code>false<code/>.
	 * @throws RepositorioException
	 *             levantada quando ocorre erro no repositorio.
	 */
	boolean atualizar(ContaAbstrata conta) throws RepositorioException;

	/**
	 * Indica se existe uma conta no repositorio.
	 * 
	 * @param numero
	 *            numero da conta a ser localizada.
	 * @return se conta existe.
	 * @throws RepositorioException
	 *             levantada quando ocorre erro no repositorio.
	 */
	boolean existe(String numero);

	/**
	 * Retorna um iterador para acessar sequencialmente as contas do
	 * repositorio.
	 * 
	 * @return iterador para as contas.
	 * @throws RepositorioException
	 *             levantada quando ocorre erro no repositorio.
	 */
	IteratorContaAbstrata getIterator();
}
